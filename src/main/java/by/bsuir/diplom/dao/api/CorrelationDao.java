package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CorrelationDao extends AbstractDao<Integer, Correlation> {
    private static final String GET_ALL = "SELECT * FROM correlation";
    private static final String GET_CORRELATION = "SELECT * FROM correlation WHERE ynn=:ynn";

    @Override
    public List<Correlation> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Correlation.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Correlation address = session.find(Correlation.class, id);
            session.remove(address);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Correlation getCorrelation(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_CORRELATION).addEntity(Correlation.class);
            query.setParameter("ynn", ynn);
            if (query.getSingleResult() == null) {
                return null;
            } else {
                return (Correlation) query.getSingleResult();
            }
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
