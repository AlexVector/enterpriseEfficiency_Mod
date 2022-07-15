package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.CompanyInfo;
import by.bsuir.diplom.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyInfoDao extends AbstractDao<Integer, CompanyInfo>{
    private static final String GET_ALL = "SELECT * FROM company_info";
    private static final String GET_COMPANY_INFO = "SELECT * FROM company_db.company_info WHERE ynn=:ynn";

    @Override
    public List<CompanyInfo> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(CompanyInfo.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            CompanyInfo companyInfo = session.find(CompanyInfo.class, id);
            session.remove(companyInfo);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public CompanyInfo getCompanyInfo(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_COMPANY_INFO).addEntity(CompanyInfo.class);
            query.setParameter("ynn", ynn);
            return (CompanyInfo) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
