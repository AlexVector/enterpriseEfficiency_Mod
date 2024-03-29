package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.StaffDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.StaffService;

import java.util.List;

public class StaffServiceImpl extends SessionUtil implements StaffService {
    @Override
    public List<Staff> getStaffToExport(Integer com_id) throws ServiceException {
        List<Staff> list;
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        try {
            openTransactionSession();
            staffDao.setSession(getSession());
            list = staffDao.getStaffToExport(com_id);
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
    public List<Staff> getAll() throws ServiceException {
        List<Staff> list;
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        try {
            openTransactionSession();
            staffDao.setSession(getSession());
            list = staffDao.getAll();
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
            throw new ServiceException("Wrong company id for delete staff");
        }
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        try {
            openTransactionSession();
            staffDao.setSession(getSession());
            staffDao.delete(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Staff staff) throws ServiceException {
        if (staff == null) {
            throw new ServiceException("Staff info doesn't exist");
        }
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        try {
            openTransactionSession();
            staffDao.setSession(getSession());
            staffDao.edit(staff);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Staff> getStaff(Integer com_id) throws ServiceException {
        if (com_id == null || com_id < 1) {
            throw new ServiceException("Impossible to get grounds info!");
        }
        List<Staff> staffList;
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        try {
            openTransactionSession();
            staffDao.setSession(getSession());
            staffList = staffDao.getStaff(com_id);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return staffList;
    }
}
