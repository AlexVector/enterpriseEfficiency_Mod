package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface ExpensesService {
    List<Expenses> getAll() throws ServiceException;

    /**
     * Method for deleting expenses
     *
     * @param ynn ynn of expenses
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit expenses in database
     *
     * @param expenses new info about expenses
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Expenses expenses) throws ServiceException;

    /**
     * Method for getting expenses info
     *
     * @param ynn expenses ynn
     * @return object of {@code Expenses} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Expenses getExpenses(Integer ynn) throws ServiceException;
}
