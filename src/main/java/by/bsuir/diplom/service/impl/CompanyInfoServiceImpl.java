package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.CompanyInfo;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CompanyInfoDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CompanyInfoService;

import java.util.List;

public class CompanyInfoServiceImpl extends SessionUtil implements CompanyInfoService {

    @Override
    public List<CompanyInfo> getAll() throws ServiceException {
        List<CompanyInfo> list;
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        try {
            openTransactionSession();
            companyInfoDao.setSession(getSession());
            list = companyInfoDao.getAll();
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
            throw new ServiceException("Wrong ynn for delete company info");
        }
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        try {
            openTransactionSession();
            companyInfoDao.setSession(getSession());
            companyInfoDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(CompanyInfo companyInfo) throws ServiceException {
        if (companyInfo == null) {
            throw new ServiceException("Company info doesn't exist");
        }
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        try {
            openTransactionSession();
            companyInfoDao.setSession(getSession());
            companyInfoDao.edit(companyInfo);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public CompanyInfo getCompanyInfo(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get company info!");
        }
        CompanyInfo companyInfo;
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        try {
            openTransactionSession();
            companyInfoDao.setSession(getSession());
            companyInfo = companyInfoDao.getCompanyInfo(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return companyInfo;
    }
}
