package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CropProductionService {
    List<CropProduction> getAll() throws ServiceException;

    /**
     * Method for deleting crop production
     *
     * @param ynn ynn of crop production
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

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
     * @param ynn crop production ynn
     * @return object of {@code CropProduction} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    List<CropProduction> getCropProduction(Integer ynn) throws ServiceException;

    CropProduction getIndicators(Integer ynn) throws ServiceException;
}
