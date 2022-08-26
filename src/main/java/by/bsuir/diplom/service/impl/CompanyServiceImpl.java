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
    public void delete(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Wrong ynn for delete company");
        }
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            companyDao.delete(ynn);
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
    public Company getCompany(Integer ynn) throws ServiceException {
        DataCalculation dataCalculation = new DataCalculation();
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get company info!");
        }
        Company company;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            company = companyDao.getCompany(ynn);
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
            company.setAddress(addressDao.getAddress(company.getYnn()));
            company.setCattle(cattleDao.getCattle(company.getYnn()));
            company.setCoefficients(coefficientsDao.getCoefficients(company.getYnn()));
            company.setCompanyInfo(companyInfoDao.getCompanyInfo(company.getYnn()));
            company.setCropProductions(cropProductionDao.getCropProduction(company.getYnn()));
            company.setDairyProducts(dairyProductsDao.getDairyProducts(company.getYnn()));
            company.setExpenses(expensesDao.getExpenses(company.getYnn()));
            company.setFixedAssets(fixedAssetsDao.getFixedAssets(company.getYnn()));
            company.setGrounds(groundsDao.getGround(company.getYnn()));
            company.setSalesReturn(salesReturnDao.getSalesReturn(company.getYnn()));
            company.setStaff(staffDao.getStaff(company.getYnn()));
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
    public List<Company> getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, int operationsCounter) throws DaoException {
        List<Company> list = null;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            list = companyDao.getAdvancedSearchResult(parameters, statuses, types, values, text_values, operationsCounter);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
        } finally {
            closeSession();
        }
        return list;
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
        List<Integer> ynnList;
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        try {
            openTransactionSession();
            companyDao.setSession(getSession());
            ynnList = companyDao.getAllYnn();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        for (Integer ynn : ynnList) {
            list.add(getCompany(ynn));
        }
        return list;
    }

    @Override
    public List<String> calcCorrelation(Integer ynn) throws ServiceException {
        Company company = getCompany(ynn);
        CorrelationService correlationService = new CorrelationServiceImpl();
        DataCalculation dataCalculation = new DataCalculation();
        Correlation companyCorrelation = correlationService.getCorrelation(ynn);
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
