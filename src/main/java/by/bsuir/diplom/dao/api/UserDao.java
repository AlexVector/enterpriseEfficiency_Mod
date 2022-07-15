package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Users;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends AbstractDao<Integer, Users> {
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String AUTHORIZATION = "SELECT * FROM users WHERE email=:login";
    private static final String GET_USER_LOGIN = "SELECT email FROM users WHERE id=:id";
    private static final String GET_USER_PASSWORD = "SELECT password FROM users WHERE email=:login";
    private static final String GET_USER_ROLE = "SELECT role FROM users WHERE id=:id";

    @Override
    public List<Users> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Users.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Users user = session.find(Users.class, id);
            session.remove(user);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Integer addUser(Users user) throws DaoException {
        try {
            return (Integer) session.save(user);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Users authorization(String login) throws DaoException {
        try {
            Query query = session.createNativeQuery(AUTHORIZATION).addEntity(Users.class);
            query.setParameter("login", login);
            return (Users) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Users getUser(Integer id) throws DaoException {
        try {
            return session.find(Users.class, id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public String getUserLogin(Integer id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_USER_LOGIN);
            query.setParameter("id", id);
            return (String) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public String getUserPassword(String login) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_USER_PASSWORD);
            query.setParameter("login", login);
            return (String) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Integer getUserRole(Integer id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_USER_ROLE);
            query.setParameter("id", id);
            return Integer.valueOf(String.valueOf(query.getSingleResult()));
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

}
