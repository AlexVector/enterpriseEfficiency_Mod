package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CropProductionService {
    List<CropProduction> getCropProductionToExport(Integer ynn) throws ServiceException;

    List<CropProduction> getAll() throws ServiceException;

    /**
     * Method for deleting crop production
     *
     * @param com_id of crop production
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit crop production in database
     *
     * @param cropProduction new info about crop production
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(CropProduction cropProduction) throws ServiceException;

    /**
     * Method for getting crop production info
     *
     * @param com_id crop production com_id
     * @return object of {@code CropProduction} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    List<CropProduction> getCropProduction(Integer com_id) throws ServiceException;

    CropProduction getIndicators(Integer com_id) throws ServiceException;
}
