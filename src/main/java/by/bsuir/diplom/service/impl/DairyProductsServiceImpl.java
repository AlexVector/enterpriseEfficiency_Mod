package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.DairyProducts;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.DairyProductsDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.DairyProductsService;

import java.util.List;

public class DairyProductsServiceImpl extends SessionUtil implements DairyProductsService {

    @Override
    public List<DairyProducts> getAll() throws ServiceException {
        List<DairyProducts> list;
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        try {
            openTransactionSession();
            dairyProductsDao.setSession(getSession());
            list = dairyProductsDao.getAll();
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
            throw new ServiceException("Wrong ynn for delete coefficients");
        }
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        try {
            openTransactionSession();
            dairyProductsDao.setSession(getSession());
            dairyProductsDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(DairyProducts dairyProducts) throws ServiceException {
        if (dairyProducts == null) {
            throw new ServiceException("Dairy products info doesn't exist");
        }
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        try {
            openTransactionSession();
            dairyProductsDao.setSession(getSession());
            dairyProductsDao.edit(dairyProducts);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public DairyProducts getDairyProducts(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get dairy products info!");
        }
        DairyProducts dairyProducts;
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        try {
            openTransactionSession();
            dairyProductsDao.setSession(getSession());
            dairyProducts = dairyProductsDao.getDairyProducts(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return dairyProducts;
    }
}
