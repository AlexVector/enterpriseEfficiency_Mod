package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.bean.SalesReturn;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface SalesReturnService {
    List<SalesReturn> getAll() throws ServiceException;

    /**
     * Method for deleting sales return
     *
     * @param ynn ynn of sales return
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit sales return in database
     *
     * @param salesReturn new info about sales return
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(SalesReturn salesReturn) throws ServiceException;

    /**
     * Method for getting sales return info
     *
     * @param ynn sales return ynn
     * @return object of {@code SalesReturn} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    SalesReturn getSalesReturn(Integer ynn) throws ServiceException;
}
