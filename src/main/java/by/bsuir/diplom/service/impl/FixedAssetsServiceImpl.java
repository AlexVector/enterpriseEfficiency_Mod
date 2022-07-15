package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.FixedAssets;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.FixedAssetsDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.FixedAssetsService;

import java.util.List;

public class FixedAssetsServiceImpl extends SessionUtil implements FixedAssetsService {

    @Override
    public List<FixedAssets> getAll() throws ServiceException {
        List<FixedAssets> list;
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        try {
            openTransactionSession();
            fixedAssetsDao.setSession(getSession());
            list = fixedAssetsDao.getAll();
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
            throw new ServiceException("Wrong ynn for delete fixed assets");
        }
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        try {
            openTransactionSession();
            fixedAssetsDao.setSession(getSession());
            fixedAssetsDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(FixedAssets fixedAssets) throws ServiceException {
        if (fixedAssets == null) {
            throw new ServiceException("Fixed assets info doesn't exist");
        }
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        try {
            openTransactionSession();
            fixedAssetsDao.setSession(getSession());
            fixedAssetsDao.edit(fixedAssets);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public FixedAssets getFixedAssets(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get fixed assets info!");
        }
        FixedAssets fixedAssets;
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        try {
            openTransactionSession();
            fixedAssetsDao.setSession(getSession());
            fixedAssets = fixedAssetsDao.getFixedAssets(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return fixedAssets;
    }
}
