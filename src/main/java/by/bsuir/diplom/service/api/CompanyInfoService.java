package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.CompanyInfo;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CompanyInfoService {
    List<CompanyInfo> getAll() throws ServiceException;

    /**
     * Method for deleting company info
     *
     * @param com_id of company info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit company info in database
     *
     * @param companyInfo new info about company info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(CompanyInfo companyInfo) throws ServiceException;

    /**
     * Method for getting company info
     *
     * @param com_id company info com_id
     * @return object of {@code CompanyInfo} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    CompanyInfo getCompanyInfo(Integer com_id) throws ServiceException;
}
