package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Coefficients;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CoefficientsService {
    List<Coefficients> getAll() throws ServiceException;

    /**
     * Method for deleting coefficients
     *
     * @param ynn ynn of coefficients
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit coefficients in database
     *
     * @param coefficients new info about coefficients
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Coefficients coefficients) throws ServiceException;

    /**
     * Method for getting coefficients info
     *
     * @param ynn coefficients ynn
     * @return object of {@code Coefficients} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Coefficients getCoefficients(Integer ynn) throws ServiceException;
}
