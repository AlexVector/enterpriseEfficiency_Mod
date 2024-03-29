package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Coefficients;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CoefficientsDao extends AbstractDao<Integer, Coefficients> {
    private static final String GET_ALL = "SELECT * FROM coefficients";
    private static final String GET_COEFFICIENTS = "SELECT * FROM new_db.coefficients WHERE com_id=:com_id";

    @Override
    public List<Coefficients> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Coefficients.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Coefficients coefficients = session.find(Coefficients.class, id);
            session.remove(coefficients);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Coefficients getCoefficients(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_COEFFICIENTS).addEntity(Coefficients.class);
            query.setParameter("com_id", com_id);
            return (Coefficients) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
