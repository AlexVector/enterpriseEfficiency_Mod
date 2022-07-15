package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class ExpensesDao extends AbstractDao<Integer, Expenses>{
    private static final String GET_ALL = "SELECT * FROM expenses";
    private static final String GET_EXPENSES = "SELECT * FROM company_db.expenses WHERE ynn=:ynn";

    @Override
    public List<Expenses> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Expenses.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Expenses expenses = session.find(Expenses.class, id);
            session.remove(expenses);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Expenses getExpenses(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_EXPENSES).addEntity(Expenses.class);
            query.setParameter("ynn", ynn);
            return (Expenses) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
