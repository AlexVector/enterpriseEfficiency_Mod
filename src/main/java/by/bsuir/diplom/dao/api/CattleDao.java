package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Cattle;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CattleDao extends AbstractDao<Integer, Cattle> {
    private static final String GET_ALL = "SELECT * FROM cattle";
    private static final String GET_CATTLE = "SELECT * FROM company_db.cattle WHERE ynn=:ynn";

    @Override
    public List<Cattle> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Cattle.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Cattle cattle = session.find(Cattle.class, id);
            session.remove(cattle);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Cattle getCattle(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_CATTLE).addEntity(Cattle.class);
            query.setParameter("ynn", ynn);
            return (Cattle) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
