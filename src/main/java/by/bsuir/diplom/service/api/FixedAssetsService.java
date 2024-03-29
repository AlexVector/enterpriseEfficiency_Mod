package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.bean.FixedAssets;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface FixedAssetsService {
    List<FixedAssets> getAll() throws ServiceException;

    /**
     * Method for deleting fixed assets
     *
     * @param com_id of fixed assets
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit fixed assets in database
     *
     * @param fixedAssets new info about fixed assets
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(FixedAssets fixedAssets) throws ServiceException;

    /**
     * Method for getting fixed assets info
     *
     * @param com_id fixed assets com_id
     * @return object of {@code FixedAssets} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    FixedAssets getFixedAssets(Integer com_id) throws ServiceException;
}
