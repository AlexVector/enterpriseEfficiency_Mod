package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Users;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface UserService {
    /**
     * Method for getting all users
     *
     * @return {@code List<Users>} with info that lies in database
     * @throws ServiceException when the error occurred on the dao layer
     */
    List<Users> getAllUser() throws ServiceException;

    /**
     * Method for checking user info which user entered, and if data will be correct add user into database
     *
     * @param user            all info that user entered
     * @param confirmPassword password confirmation
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void registration(Users user, String confirmPassword) throws ServiceException;

    /**
     * Method for deleting user
     *
     * @param id id of user
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer id) throws ServiceException;

    /**
     * Method for validating data before edit user in database
     *
     * @param user       new info about user
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Users user) throws ServiceException;

    /**
     * Method for validating data before edit user in database
     *
     * @param user    new info about user
     * @param oldPass password from the database
     * @param newPass password for re-write password in database
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Users user, String oldPass, String newPass) throws ServiceException;

    /**
     * Method for validating data before getting user info from database
     *
     * @param login    that user entered
     * @param password that user entered
     * @return {@code Users} class with all user info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Users authorization(String login, String password) throws ServiceException;

    /**
     * Method for getting user info
     *
     * @param id user id
     * @return object of {@code Users} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Users getUser(Integer id) throws ServiceException;

}
