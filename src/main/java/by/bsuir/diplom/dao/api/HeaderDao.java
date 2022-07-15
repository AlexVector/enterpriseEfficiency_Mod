package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Header;
import by.bsuir.diplom.dao.exception.DaoException;

import java.util.List;

public class HeaderDao extends AbstractDao<Integer, Header> {
    private static final String GET_ALL = "SELECT * FROM header";
    private static final String DELETE_ALL = "TRUNCATE TABLE company_db.header;";

    @Override
    public List<Header> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Header.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Header header = session.find(Header.class, id);
            session.remove(header);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public void deleteAll() throws DaoException {
        try {
            session.createNativeQuery(DELETE_ALL).executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
