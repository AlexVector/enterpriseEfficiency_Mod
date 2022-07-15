package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CropProductionDao extends AbstractDao<Integer, CropProduction> {
    private static final String GET_ALL = "SELECT * FROM crop_production";
    private static final String GET_CROP_PRODUCTION = "SELECT * FROM crop_production WHERE ynn=:ynn";
    private static final String GET_INDICATOR_FOR_CALCULATION = "SELECT * FROM company_db.crop_production WHERE ynn=:company_ynn order by id DESC LIMIT 1";

    @Override
    public List<CropProduction> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(CropProduction.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            CropProduction cropProduction = session.find(CropProduction.class, id);
            session.remove(cropProduction);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<CropProduction> getCropProduction(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_CROP_PRODUCTION).addEntity(CropProduction.class);
            query.setParameter("ynn", ynn);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public CropProduction getIndicators(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_INDICATOR_FOR_CALCULATION).addEntity(CropProduction.class);
            query.setParameter("company_ynn", ynn);
            return (CropProduction) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
