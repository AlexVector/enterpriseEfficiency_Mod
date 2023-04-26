package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CropProductionDao extends AbstractDao<Integer, CropProduction> {
    private static final String GET_ALL = "SELECT * FROM crop_production";
    private static final String GET_CROP_PRODUCTION = "SELECT * FROM crop_production WHERE com_id=:com_id";
    private static final String GET_INDICATOR_FOR_CALCULATION = "SELECT * FROM new_db.crop_production WHERE com_id=:com_id order by com_id DESC LIMIT 1";

    //my mod
    private static final String GET_CROP_PROD_FOR_EXPORT = "select * from crop_production inner join company c on c.com_id = crop_production.com_id where c.com_id=:com_id order by crop_production.column_index";
    
    public List<CropProduction> getCropProductionToExport(Integer com_id) throws DaoException{
        try{
            Query query = session.createNativeQuery(GET_CROP_PROD_FOR_EXPORT).addEntity(CropProduction.class);
            query.setParameter("com_id", com_id);
            return query.list();
        } catch (Exception ex){
            throw new DaoException(ex);
        }
    }

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

    public List<CropProduction> getCropProduction(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_CROP_PRODUCTION).addEntity(CropProduction.class);
            query.setParameter("com_id", com_id);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public CropProduction getIndicators(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_INDICATOR_FOR_CALCULATION).addEntity(CropProduction.class);
            query.setParameter("com_id", com_id);
            return (CropProduction) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
