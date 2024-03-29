package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Cattle;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CattleService {
    List<Cattle> getAll() throws ServiceException;

    /**
     * Method for deleting cattle
     *
     * @param com_id of cattle
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit cattle in database
     *
     * @param cattle new info about cattle
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Cattle cattle) throws ServiceException;

    /**
     * Method for getting cattle info
     *
     * @param com_id cattle com_id
     * @return object of {@code Cattle} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Cattle getCattle(Integer com_id) throws ServiceException;
}
