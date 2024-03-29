package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CropProductionDao;
import by.bsuir.diplom.dao.api.StaffDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CropProductionService;

import java.util.List;

public class CropProductionServiceImpl extends SessionUtil implements CropProductionService {

    @Override
    public List<CropProduction> getCropProductionToExport(Integer com_id) throws ServiceException {
        List<CropProduction> list;
        CropProductionDao cropprodDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropprodDao.setSession(getSession());
            list = cropprodDao.getCropProductionToExport(com_id);
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
    public List<CropProduction> getAll() throws ServiceException {
        List<CropProduction> list;
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            list = cropProductionDao.getAll();
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
            throw new ServiceException("Wrong company id for delete crop production");
        }
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            cropProductionDao.delete(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(CropProduction cropProduction) throws ServiceException {
        if (cropProduction == null) {
            throw new ServiceException("CropProduction info doesn't exist");
        }
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            cropProductionDao.edit(cropProduction);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<CropProduction> getCropProduction(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get crop production info!");
        }
        List<CropProduction> cropProductions;
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            cropProductions = cropProductionDao.getCropProduction(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return cropProductions;
    }

    @Override
    public CropProduction getIndicators(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get indicators!");
        }
        CropProduction cropProduction;
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            cropProduction = cropProductionDao.getIndicators(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return cropProduction;
    }
}
