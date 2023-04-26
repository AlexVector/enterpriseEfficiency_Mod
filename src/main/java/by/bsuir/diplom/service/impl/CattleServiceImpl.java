package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Cattle;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CattleDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CattleService;

import java.util.List;

public class CattleServiceImpl extends SessionUtil implements CattleService {

    @Override
    public List<Cattle> getAll() throws ServiceException {
        List<Cattle> list;
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            openTransactionSession();
            cattleDao.setSession(getSession());
            list = cattleDao.getAll();
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
            throw new ServiceException("Wrong company id for delete cattle");
        }
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            openTransactionSession();
            cattleDao.setSession(getSession());
            cattleDao.delete(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Cattle cattle) throws ServiceException {
        if (cattle == null) {
            throw new ServiceException("Cattle info doesn't exist");
        }
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            openTransactionSession();
            cattleDao.setSession(getSession());
            cattleDao.edit(cattle);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Cattle getCattle(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get cattle info!");
        }
        Cattle cattle;
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            openTransactionSession();
            cattleDao.setSession(getSession());
            cattle = cattleDao.getCattle(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return cattle;
    }
}
