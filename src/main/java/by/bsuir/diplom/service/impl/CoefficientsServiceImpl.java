package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Coefficients;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CoefficientsDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CoefficientsService;

import java.util.List;

public class CoefficientsServiceImpl extends SessionUtil implements CoefficientsService {

    @Override
    public List<Coefficients> getAll() throws ServiceException {
        List<Coefficients> list;
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        try {
            openTransactionSession();
            coefficientsDao.setSession(getSession());
            list = coefficientsDao.getAll();
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
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        try {
            openTransactionSession();
            coefficientsDao.setSession(getSession());
            coefficientsDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Coefficients coefficients) throws ServiceException {
        if (coefficients == null) {
            throw new ServiceException("Coefficients info doesn't exist");
        }
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        try {
            openTransactionSession();
            coefficientsDao.setSession(getSession());
            coefficientsDao.edit(coefficients);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Coefficients getCoefficients(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get coefficients info!");
        }
        Coefficients coefficients;
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        try {
            openTransactionSession();
            coefficientsDao.setSession(getSession());
            coefficients = coefficientsDao.getCoefficients(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return coefficients;
    }
}
