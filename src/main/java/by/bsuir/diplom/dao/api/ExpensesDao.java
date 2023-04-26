package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class ExpensesDao extends AbstractDao<Integer, Expenses>{
    private static final String GET_ALL = "SELECT * FROM expenses";
    private static final String GET_EXPENSES = "SELECT * FROM new_db.expenses WHERE com_id=:com_id";

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

    public Expenses getExpenses(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_EXPENSES).addEntity(Expenses.class);
            query.setParameter("com_id", com_id);
            return (Expenses) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
