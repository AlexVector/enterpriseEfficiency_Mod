package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Address;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class AddressDao extends AbstractDao<Integer, Address> {
    private static final String GET_ALL = "SELECT * FROM address";
    private static final String GET_ADDRESS = "SELECT * FROM company_db.address WHERE ynn=:ynn";
    private static final String GET_AREAS = "SELECT DISTINCT area FROM company_db.address";
    private static final String GET_DISTRICT = "SELECT DISTINCT district FROM company_db.address WHERE area=:area";

    @Override
    public List<Address> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Address.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Address address = session.find(Address.class, id);
            session.remove(address);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Address getAddress(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_ADDRESS).addEntity(Address.class);
            query.setParameter("ynn", ynn);
            return (Address) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<String> getAreas() throws DaoException {
        try {
            return session.createNativeQuery(GET_AREAS).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<String> getDistrict(String area) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_DISTRICT);
            query.setParameter("area", area);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
