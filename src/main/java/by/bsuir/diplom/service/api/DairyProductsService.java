package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.DairyProducts;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface DairyProductsService {
    List<DairyProducts> getAll() throws ServiceException;

    /**
     * Method for deleting dairy products
     *
     * @param ynn ynn of dairy products
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit dairy products in database
     *
     * @param dairyProducts new info about dairy products
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(DairyProducts dairyProducts) throws ServiceException;

    /**
     * Method for getting dairy products info
     *
     * @param ynn dairy products ynn
     * @return object of {@code DairyProducts} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    DairyProducts getDairyProducts(Integer ynn) throws ServiceException;
}
