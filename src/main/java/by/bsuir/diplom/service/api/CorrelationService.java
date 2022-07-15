package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CorrelationService {

    List<Correlation> getAll() throws ServiceException;

    /**
     * Method for deleting correlation
     *
     * @param ynn ynn of correlation
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before add correlation in database
     *
     * @param correlation info about correlation
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void add(Correlation correlation) throws ServiceException;

    /**
     * Method for validating data before edit correlation in database
     *
     * @param correlation new info about correlation
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Correlation correlation) throws ServiceException;

    /**
     * Method for getting correlation info
     *
     * @param ynn correlation ynn
     * @return object of {@code Correlation} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Correlation getCorrelation(Integer ynn) throws ServiceException;
}
