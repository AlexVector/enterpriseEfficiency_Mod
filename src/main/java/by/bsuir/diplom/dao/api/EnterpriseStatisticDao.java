package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.EnterpriseStatistic;
import by.bsuir.diplom.dao.exception.DaoException;

import java.util.List;

public class EnterpriseStatisticDao extends AbstractDao<Integer, EnterpriseStatistic>{
    private static final String GET_ALL = "SELECT * FROM enterprise_statistic";

    @Override
    public List<EnterpriseStatistic> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(EnterpriseStatistic.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public void merge(EnterpriseStatistic statistic) throws DaoException {
        try {
            session.merge(statistic);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            EnterpriseStatistic enterpriseStatistic = session.find(EnterpriseStatistic.class, id);
            session.remove(enterpriseStatistic);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
