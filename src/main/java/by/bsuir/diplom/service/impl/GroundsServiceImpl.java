package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.bean.Grounds;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CropProductionDao;
import by.bsuir.diplom.dao.api.GroundsDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.GroundsService;

import java.util.List;

public class GroundsServiceImpl extends SessionUtil implements GroundsService {
    @Override
    public List<Grounds> getGroundsToExport(Integer com_id) throws ServiceException {
        List<Grounds> list;
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        try {
            openTransactionSession();
            groundsDao.setSession(getSession());
            list = groundsDao.getGroundsToExport(com_id);
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
    public List<Grounds> getAll() throws ServiceException {
        List<Grounds> list;
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        try {
            openTransactionSession();
            groundsDao.setSession(getSession());
            list = groundsDao.getAll();
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
            throw new ServiceException("Wrong company id for delete grounds");
        }
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        try {
            openTransactionSession();
            groundsDao.setSession(getSession());
            groundsDao.delete(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Grounds grounds) throws ServiceException {
        if (grounds == null) {
            throw new ServiceException("Grounds info doesn't exist");
        }
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        try {
            openTransactionSession();
            groundsDao.setSession(getSession());
            groundsDao.edit(grounds);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Grounds> getGrounds(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get grounds info!");
        }
        List<Grounds> grounds;
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        try {
            openTransactionSession();
            groundsDao.setSession(getSession());
            grounds = groundsDao.getGround(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return grounds;
    }
}
