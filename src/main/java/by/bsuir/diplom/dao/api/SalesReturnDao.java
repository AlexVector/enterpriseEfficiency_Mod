package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.SalesReturn;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class SalesReturnDao extends AbstractDao<Integer, SalesReturn> {
    private static final String GET_ALL = "SELECT * FROM sales_return";
    private static final String GET_SALES_RETURN = "SELECT * FROM company_db.sales_return WHERE ynn=:ynn";

    @Override
    public List<SalesReturn> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(SalesReturn.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            SalesReturn salesReturn = session.find(SalesReturn.class, id);
            session.remove(salesReturn);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public SalesReturn getSalesReturn(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_SALES_RETURN).addEntity(SalesReturn.class);
            query.setParameter("ynn", ynn);
            return (SalesReturn) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
