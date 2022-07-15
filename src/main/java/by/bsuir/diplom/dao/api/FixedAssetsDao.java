package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.FixedAssets;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class FixedAssetsDao extends AbstractDao<Integer, FixedAssets>{
    private static final String GET_ALL = "SELECT * FROM fixed_assets";
    private static final String GET_FIXED_ASSETS = "SELECT * FROM company_db.fixed_assets WHERE ynn=:ynn";

    @Override
    public List<FixedAssets> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(FixedAssets.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            FixedAssets fixedAssets = session.find(FixedAssets.class, id);
            session.remove(fixedAssets);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public FixedAssets getFixedAssets(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_FIXED_ASSETS).addEntity(FixedAssets.class);
            query.setParameter("ynn", ynn);
            return (FixedAssets) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
