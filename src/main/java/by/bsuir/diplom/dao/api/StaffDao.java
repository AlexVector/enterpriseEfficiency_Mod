package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class StaffDao extends AbstractDao<Integer, Staff>{
    private static final String GET_ALL = "SELECT * FROM staff";
    private static final String GET_STAFF = "SELECT * FROM staff WHERE com_id=:com_id";

    //my mod
    private static final String GET_STAFF_FOR_EXPORT = "select * from staff inner join company c on c.com_id = staff.com_id where c.com_id=:com_id order by staff.column_index";

    public List<Staff> getStaffToExport(Integer com_id) throws DaoException{
        try{
            Query query = session.createNativeQuery(GET_STAFF_FOR_EXPORT).addEntity(Staff.class);
            query.setParameter("com_id", com_id);
            return query.list();
        } catch (Exception ex){
            throw new DaoException(ex);
        }
    }

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

    public List<Staff> getStaff(Integer com_id) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_STAFF).addEntity(Staff.class);
            query.setParameter("com_id", com_id);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
