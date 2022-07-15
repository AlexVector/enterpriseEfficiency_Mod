package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.DairyProducts;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class DairyProductsDao extends AbstractDao<Integer, DairyProducts>{
    private static final String GET_ALL = "SELECT * FROM dairy_products";
    private static final String GET_DAIRY_PRODUCTS = "SELECT * FROM company_db.dairy_products WHERE ynn=:ynn";

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

    public DairyProducts getDairyProducts(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_DAIRY_PRODUCTS).addEntity(DairyProducts.class);
            query.setParameter("ynn", ynn);
            return (DairyProducts) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
