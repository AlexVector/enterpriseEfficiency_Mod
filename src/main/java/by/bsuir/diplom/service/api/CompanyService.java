package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CompanyService {

    List<Company> getAll() throws ServiceException;

    /**
     * Method for deleting company
     *
     * @param ynn ynn of company
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer ynn) throws ServiceException;

    /**
     * Method for validating data before edit company in database
     *
     * @param company new info about company
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Company company) throws ServiceException;

    /**
     * Method for getting company info
     *
     * @param ynn company ynn
     * @return object of {@code Company} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Company getCompany(Integer ynn) throws ServiceException;

    void setCompanyInfo(Company company) throws ServiceException;

    List<Company> getFilterByArea(String area) throws ServiceException;

    List<Company> getFilterByDistrict(String district) throws ServiceException;

    List<Company> calcIndicators() throws ServiceException;

    List<String> calcCorrelation(Integer ynn) throws ServiceException;

    List<Company> sortById() throws ServiceException;

    List<Company> filterByAbbreviation(String text) throws ServiceException;

    List<Company> searchByName(String text) throws ServiceException;

    List<Company> getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, int[] operationsCounter) throws DaoException;
}
