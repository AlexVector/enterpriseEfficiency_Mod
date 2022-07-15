package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CorrelationDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CorrelationService;

import java.util.List;

public class CorrelationServiceImpl extends SessionUtil implements CorrelationService {
    @Override
    public List<Correlation> getAll() throws ServiceException {
        List<Correlation> list;
        CorrelationDao correlationDao = DaoFactory.getInstance().getCorrelationDao();
        try {
            openTransactionSession();
            correlationDao.setSession(getSession());
            list = correlationDao.getAll();
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
    public void add(Correlation correlation) throws ServiceException {
        if (correlation == null) {
            throw new ServiceException("No info about correlation");
        }
        CorrelationDao correlationDao = DaoFactory.getInstance().getCorrelationDao();
        try {
            openTransactionSession();
            correlationDao.setSession(getSession());
            correlationDao.add(correlation);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void delete(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Wrong ynn for delete correlation");
        }
        CorrelationDao correlationDao = DaoFactory.getInstance().getCorrelationDao();
        try {
            openTransactionSession();
            correlationDao.setSession(getSession());
            correlationDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Correlation correlation) throws ServiceException {
        if (correlation == null) {
            throw new ServiceException("Correlation info doesn't exist");
        }
        CorrelationDao correlationDao = DaoFactory.getInstance().getCorrelationDao();
        try {
            openTransactionSession();
            correlationDao.setSession(getSession());
            correlationDao.edit(correlation);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Correlation getCorrelation(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get correlation info!");
        }
        Correlation correlation;
        CorrelationDao correlationDao = DaoFactory.getInstance().getCorrelationDao();
        try {
            openTransactionSession();
            correlationDao.setSession(getSession());
            correlation = correlationDao.getCorrelation(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            return null;
        } finally {
            closeSession();
        }
        return correlation;
    }
}
