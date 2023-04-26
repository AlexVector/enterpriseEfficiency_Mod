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
     * @param com_id of sales return
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

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
     * @param com_id sales return com_id
     * @return object of {@code SalesReturn} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    SalesReturn getSalesReturn(Integer com_id) throws ServiceException;
}
