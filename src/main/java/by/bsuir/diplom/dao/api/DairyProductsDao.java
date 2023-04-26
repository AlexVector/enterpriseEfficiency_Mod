package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.DairyProducts;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class DairyProductsDao extends AbstractDao<Integer, DairyProducts>{
    private static final String GET_ALL = "SELECT * FROM dairy_products";
    private static final String GET_DAIRY_PRODUCTS = "SELECT * FROM new_db.dairy_products WHERE com_id=:com_id";

    @Override
    public List<DairyProducts> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(DairyProducts.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            DairyProducts dairyProducts = session.find(DairyProducts.class, id);
            session.remove(dairyProducts);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public DairyProducts getDairyProducts(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_DAIRY_PRODUCTS).addEntity(DairyProducts.class);
            query.setParameter("com_id", com_id);
            return (DairyProducts) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
