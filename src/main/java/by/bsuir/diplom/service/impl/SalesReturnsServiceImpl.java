package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.SalesReturn;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.SalesReturnDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.SalesReturnService;

import java.util.List;

public class SalesReturnsServiceImpl extends SessionUtil implements SalesReturnService {

    @Override
    public List<SalesReturn> getAll() throws ServiceException {
        List<SalesReturn> list;
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        try {
            openTransactionSession();
            salesReturnDao.setSession(getSession());
            list = salesReturnDao.getAll();
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
            throw new ServiceException("Wrong ynn for delete sales return");
        }
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        try {
            openTransactionSession();
            salesReturnDao.setSession(getSession());
            salesReturnDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(SalesReturn salesReturn) throws ServiceException {
        if (salesReturn == null) {
            throw new ServiceException("Sales return info doesn't exist");
        }
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        try {
            openTransactionSession();
            salesReturnDao.setSession(getSession());
            salesReturnDao.edit(salesReturn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public SalesReturn getSalesReturn(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get sales return info!");
        }
        SalesReturn salesReturn;
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        try {
            openTransactionSession();
            salesReturnDao.setSession(getSession());
            salesReturn = salesReturnDao.getSalesReturn(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return salesReturn;
    }
}
