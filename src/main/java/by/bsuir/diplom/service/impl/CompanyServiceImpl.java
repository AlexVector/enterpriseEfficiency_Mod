package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.*;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.api.*;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.calc.DataCalculation;
import by.bsuir.diplom.service.calc.DataManipulation;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceImpl extends SessionUtil implements CompanyService {
    @Override
    public void deleteAll() throws ServiceException {
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyDao.deleteAll();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Company> getAll() throws ServiceException {
        List<Company> list;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getAll();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public void delete(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Wrong company id for delete company");
        }
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyDao.delete(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Company company) throws ServiceException {
        if (company == null) {
            throw new ServiceException("Company info doesn't exist");
        }
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyDao.edit(company);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Company getCompany(Integer com_id) throws ServiceException {
        DataCalculation dataCalculation = new DataCalculation();
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get company info!");
        }
        Company company;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            company = companyDao.getCompany(com_id);
            setCompanyInfo(company);
            dataCalculation.calcIndicators(company);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return company;
    }

    @Override
    public List<Company> getListOfSameCompanies(Integer ynn) throws ServiceException {
        DataCalculation dataCalculation = new DataCalculation();
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get company info!");
        }
        List<Company> companyDynamicList;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyDynamicList = companyDao.getCompaniesInfoWithSameYnn(ynn);
            for (Company company: companyDynamicList){
                setCompanyInfo(company);
                dataCalculation.calcIndicators(company);
            }
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return companyDynamicList;
    }

    @Override
    public void setCompanyInfo(Company company) throws ServiceException {
        boolean flag = getSession().isConnected();
        DataCalculation dataCalculation = new DataCalculation();
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        EnterpriseStatisticDao enterpriseStatisticDao = DaoFactory.getInstance().getEnterpriseStatisticDao();
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            if (!flag) {
                openTransactionSession();
            }
            companyInfoDao.setSession(getSession());
            addressDao.setSession(getSession());
            enterpriseStatisticDao.setSession(getSession());
            fixedAssetsDao.setSession(getSession());
            salesReturnDao.setSession(getSession());
            coefficientsDao.setSession(getSession());
            staffDao.setSession(getSession());
            cropProductionDao.setSession(getSession());
            expensesDao.setSession(getSession());
            groundsDao.setSession(getSession());
            dairyProductsDao.setSession(getSession());
            cattleDao.setSession(getSession());
            company.setAddress(addressDao.getAddress(company.getCom_id()));
            company.setCattle(cattleDao.getCattle(company.getCom_id()));
            company.setCoefficients(coefficientsDao.getCoefficients(company.getCom_id()));
            company.setCompanyInfo(companyInfoDao.getCompanyInfo(company.getCom_id()));
            //could mot execute query on crop_production
            company.setCropProductions(cropProductionDao.getCropProduction(company.getCom_id()));
            company.setDairyProducts(dairyProductsDao.getDairyProducts(company.getCom_id()));
            company.setExpenses(expensesDao.getExpenses(company.getCom_id()));
            company.setFixedAssets(fixedAssetsDao.getFixedAssets(company.getCom_id()));
            company.setGrounds(groundsDao.getGround(company.getCom_id()));
            company.setSalesReturn(salesReturnDao.getSalesReturn(company.getCom_id()));
            company.setStaff(staffDao.getStaff(company.getCom_id()));
            if (!flag) {
                dataCalculation.calcIndicators(company);
                commitTransactionSession();
            }
        } catch (DaoException e) {
            if (!flag) {
                rollbackTransactionSession();
            }
            throw new ServiceException(e);
        } finally {
            if (!flag) {
                closeSession();
            }
        }

//        AddressService addressService = new AddressServiceImpl();
//        CattleService cattleService = new CattleServiceImpl();
//        CoefficientsService coefficientsService = new CoefficientsServiceImpl();
//        CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();
////        CorrelationService correlationService = new CorrelationServiceImpl();
//        CropProductionService cropProductionService = new CropProductionServiceImpl();
//        DairyProductsService dairyProductsService = new DairyProductsServiceImpl();
//        ExpensesService expensesService = new ExpensesServiceImpl();
//        FixedAssetsService fixedAssetsService = new FixedAssetsServiceImpl();
//        GroundsService groundsService = new GroundsServiceImpl();
//        SalesReturnService salesReturnService = new SalesReturnsServiceImpl();
//        StaffService staffService = new StaffServiceImpl();
//        company.setAddress(addressService.getAddress(company.getYnn()));
//        company.setCattle(cattleService.getCattle(company.getYnn()));
//        company.setCoefficients(coefficientsService.getCoefficients(company.getYnn()));
//        company.setCompanyInfo(companyInfoService.getCompanyInfo(company.getYnn()));
////        company.setCorrelation(correlationService.getCorrelation(company.getYnn()));
//        company.setCropProductions(cropProductionService.getCropProduction(company.getYnn()));
//        company.setDairyProducts(dairyProductsService.getDairyProducts(company.getYnn()));
//        company.setExpenses(expensesService.getExpenses(company.getYnn()));
//        company.setFixedAssets(fixedAssetsService.getFixedAssets(company.getYnn()));
//        company.setGrounds(groundsService.getGrounds(company.getYnn()));
//        company.setSalesReturn(salesReturnService.getSalesReturn(company.getYnn()));
//        company.setStaff(staffService.getStaff(company.getYnn()));
    }

    @Override
    public List<Company> getFilterByArea(String area) throws ServiceException {
        if (area == null || "".equals(area)) {
            throw new ServiceException("Wrong text for filter");
        }
        List<Company> list;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getFilterByArea(area);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }
    //My modification
    @Override
    public List<Company> getAdvancedSearchResultList(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, String[] area_value, String[] district_value, int operationsCounter) throws DaoException {
        List<Company> list = null;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getAdvancedSearchResultList(parameters, statuses, types, values, text_values, area_value, district_value, operationsCounter);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public Double getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, String[] area_value, String[] district_value, int operationsCounter) throws DaoException {
        Double result = null;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            result = companyDao.getAdvancedSearchResult(parameters, statuses, types, values, text_values, area_value, district_value, operationsCounter);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
        } finally {
            closeSession();
        }
        return result;
    }
    //My modification


    @Override
    public List<Company> getFilterByDistrict(String district) throws ServiceException {
        if (district == null || "".equals(district)) {
            throw new ServiceException("Wrong text for filter");
        }
        List<Company> list;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getFilterByDistrict(district);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public List<Company> calcIndicators() throws ServiceException {
        List<Company> list = new ArrayList<>();
        List<Integer> companyIdList;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyIdList = companyDao.getAllCompanyIds();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        for (Integer ynn : companyIdList) {
            list.add(getCompany(ynn));
        }
        return list;
    }

    @Override
    public List<String> calcCorrelation(Integer com_id) throws ServiceException {
        Company company = getCompany(com_id);
        CorrelationService correlationService = new CorrelationServiceImpl();
        DataCalculation dataCalculation = new DataCalculation();
        Correlation companyCorrelation = correlationService.getCorrelation(com_id);
        if (companyCorrelation == null) {
            dataCalculation.calcCorrelation(company);
        }
        return DataManipulation.getCorrelationConclusion(company);
    }

    @Override
    public List<Company> sortById() throws ServiceException {
        List<Company> list;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        DataCalculation dataCalculation = new DataCalculation();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getSortedById();
            if (!list.isEmpty()) {
                for (Company company : list) {
                    dataCalculation.calcIndicators(company);
                }
            }
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public List<Company> filterByAbbreviation(String text) throws ServiceException {
        if (text == null || "".equals(text)) {
            throw new ServiceException("Wrong search text");
        }
        List<Company> list;
        text = "%" + text + "%";
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.filterByAbbreviation(text);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public List<Company> searchByName(String text) throws ServiceException {
        if (text == null || "".equals(text)) {
            throw new ServiceException("Wrong search text");
        }
        List<Company> list;
        text = "%" + text + "%";
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.searchByName(text);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }
}
