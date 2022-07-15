package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Grounds;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface GroundsService {
    List<Grounds> getAll() throws ServiceException;

    /**
     * Method for deleting grounds
     *
     * @param ynn ynn of grounds
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit grounds in database
     *
     * @param grounds new info about grounds
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Grounds grounds) throws ServiceException;

    /**
     * Method for getting grounds info
     *
     * @param ynn grounds ynn
     * @return object of {@code Grounds} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    List<Grounds> getGrounds(Integer ynn) throws ServiceException;
}
