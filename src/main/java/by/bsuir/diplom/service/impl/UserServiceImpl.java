package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Users;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.UserDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.UserService;
import by.bsuir.diplom.service.validation.PBKDF2Hasher;
import by.bsuir.diplom.service.validation.UserValidator;

import java.util.List;

public class UserServiceImpl extends SessionUtil implements UserService {
    private static PBKDF2Hasher hasher = new PBKDF2Hasher(14);

    @Override
    public List<Users> getAllUser() throws ServiceException {
        List<Users> list;
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            list = userDao.getAll();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public void registration(Users user, String confirmPassword) throws ServiceException {
        if (user == null) {
            throw new ServiceException("Can not register user. User not exist.");
        }
        if (!user.getPassword().equals(confirmPassword)) {
            throw new ServiceException("Passwords don't match");
        }
        validateUserData(user);
//        user.setRole(UserRole.ACCOUNTANT);
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            char[] pass = user.getPassword().toCharArray();
            user.setPassword(hasher.hash(pass));
            userDao.add(user);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        if (id == null || id < 1) {
            throw new ServiceException("Wrong id for delete user");
        }
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            if (userDao.getUserRole(id) == 0) {
                throw new ServiceException("Cannot delete admin");
            }
            userDao.delete(id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Users user) throws ServiceException {
        if (user == null) {
            throw new ServiceException("Can not edit user");
        }
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            userDao.edit(user);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Users user, String oldPass, String newPass) throws ServiceException {
        if (user == null) {
            throw new ServiceException("Can not edit user");
        }
        validatePasswords(oldPass, newPass);
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            char[] pass = oldPass.toCharArray();
            if (hasher.checkPassword(pass, user.getPassword())) {
                char[] newPassword = newPass.toCharArray();
                user.setPassword(hasher.hash(newPassword));
            } else {
                throw new ServiceException("Entered wrong old password");
            }
            userDao.edit(user);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Users authorization(String login, String password) throws ServiceException {
        validateAuthorizationData(login, password);
        Users user;
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            String dbPass = userDao.getUserPassword(login);
            if (dbPass == null) {
                throw new ServiceException("Entered wrong login");
            }
            char[] pass = password.toCharArray();
            if (hasher.checkPassword(pass, dbPass)) {
                user = userDao.authorization(login);
            } else {
                throw new ServiceException("Entered wrong password");
            }
            commitTransactionSession();
        } catch (DaoException | IllegalArgumentException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return user;
    }

    @Override
    public Users getUser(Integer id) throws ServiceException {
        if (id == null || id < 1) {
            throw new ServiceException("Invalid user id for take info");
        }
        Users user;
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        try {
            openTransactionSession();
            userDao.setSession(getSession());
            user = userDao.getUser(id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return user;
    }

    private void validatePasswords(String oldPass, String newPass) throws ServiceException {
        if (!UserValidator.validatePassword(oldPass)) {
            throw new ServiceException("Wrong old password");
        }
        if (!UserValidator.validatePassword(newPass)) {
            throw new ServiceException("Wrong new password");
        }
    }

    private void validateAuthorizationData(String login, String password) throws ServiceException {
        if (!UserValidator.validateLogin(login)) {
            throw new ServiceException("Wrong email");
        }
        if (!UserValidator.validatePassword(password)) {
            throw new ServiceException("Wrong password");
        }
    }

//    private void validateEditUserData(Users user) throws ServiceException {
//        if (!UserValidator.validateName(user.getName())) {
//            throw new ServiceException("Wrong name");
//        }
//        if (!UserValidator.validatePhone(user.getPhoneNumber())) {
//            throw new ServiceException("Wrong phone number");
//        }
//        if (UserValidator.validateCity(user.getCity().getId())) {
//            throw new ServiceException("Wrong cityID");
//        }
//    }

    private void validateUserData(Users user) throws ServiceException {
        if (!UserValidator.validateLogin(user.getLogin())) {
            throw new ServiceException("Wrong email");
        }
        if (!UserValidator.validatePassword(user.getPassword())) {
            throw new ServiceException("Wrong password");
        }
//        if (!UserValidator.validateName(user.getName())) {
//            throw new ServiceException("Wrong name");
//        }
//        if (!UserValidator.validatePhone(user.getPhoneNumber())) {
//            throw new ServiceException("Wrong phone number");
//        }
//        if (UserValidator.validateCity(user.getCity().getId())) {
//            throw new ServiceException("Wrong cityID");
//        }
    }
}
