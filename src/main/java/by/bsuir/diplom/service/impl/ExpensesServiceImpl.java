package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.ExpensesDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.ExpensesService;

import java.util.List;

public class ExpensesServiceImpl extends SessionUtil implements ExpensesService {

    @Override
    public List<Expenses> getAll() throws ServiceException {
        List<Expenses> list;
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        try {
            openTransactionSession();
            expensesDao.setSession(getSession());
            list = expensesDao.getAll();
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
            throw new ServiceException("Wrong ynn for delete expenses");
        }
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        try {
            openTransactionSession();
            expensesDao.setSession(getSession());
            expensesDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Expenses expenses) throws ServiceException {
        if (expenses == null) {
            throw new ServiceException("Expenses info doesn't exist");
        }
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        try {
            openTransactionSession();
            expensesDao.setSession(getSession());
            expensesDao.edit(expenses);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Expenses getExpenses(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get expenses info!");
        }
        Expenses expenses;
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        try {
            openTransactionSession();
            expensesDao.setSession(getSession());
            expenses = expensesDao.getExpenses(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return expenses;
    }
}
