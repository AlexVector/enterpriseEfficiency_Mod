package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class StaffDao extends AbstractDao<Integer, Staff>{
    private static final String GET_ALL = "SELECT * FROM staff";
    private static final String GET_STAFF = "SELECT * FROM staff WHERE ynn=:ynn";

    @Override
    public List<Staff> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Staff.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Staff staff = session.find(Staff.class, id);
            session.remove(staff);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Staff> getStaff(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_STAFF).addEntity(Staff.class);
            query.setParameter("ynn", ynn);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
