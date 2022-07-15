package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Grounds;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class GroundsDao extends AbstractDao<Integer, Grounds>{
    private static final String GET_ALL = "SELECT * FROM grounds";
    private static final String GET_GROUND = "SELECT * FROM grounds WHERE ynn=:ynn";

    @Override
    public List<Grounds> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Grounds.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Grounds grounds = session.find(Grounds.class, id);
            session.remove(grounds);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Grounds> getGround(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_GROUND).addEntity(Grounds.class);
            query.setParameter("ynn", ynn);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
