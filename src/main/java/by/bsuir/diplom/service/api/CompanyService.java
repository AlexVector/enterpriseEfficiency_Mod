package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface CompanyService {
    void deleteAll() throws ServiceException;
    List<Company> getAll() throws ServiceException;

    /**
     * Method for deleting company
     *
     * @param com_id of company
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

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
     * @param com_id company com_id
     * @return object of {@code Company} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Company getCompany(Integer com_id) throws ServiceException;

    List<Company> getListOfSameCompanies(Integer ynn) throws ServiceException;

    void setCompanyInfo(Company company) throws ServiceException;

    List<Company> getFilterByArea(String area) throws ServiceException;

    List<Company> getFilterByDistrict(String district) throws ServiceException;

    List<Company> calcIndicators() throws ServiceException;

    List<String> calcCorrelation(Integer com_id) throws ServiceException;

    List<Company> sortById() throws ServiceException;

    List<Company> filterByAbbreviation(String text) throws ServiceException;

    List<Company> searchByName(String text) throws ServiceException;

    Double getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, String[] area_value, String[] district_value, int operationsCounter) throws DaoException;
    List<Company> getAdvancedSearchResultList(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, String[] area_value, String[] district_value, int operationsCounter) throws DaoException;
}
