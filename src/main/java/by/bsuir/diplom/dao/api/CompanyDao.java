package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.dao.exception.DaoException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import java.util.List;

public class CompanyDao extends AbstractDao<Integer, Company> {
    private static final String GET_ALL = "SELECT * FROM company";
    private static final String GET_ALL_YNN = "SELECT ynn FROM company";
    private static final String GET_COMPANY = "SELECT * FROM company WHERE ynn=:ynn";
    private static final String FILTER_BY_AREA = "SELECT company.* FROM company_db.company LEFT JOIN address ON company.ynn = address.ynn where area=:area";
    private static final String FILTER_BY_DISTRICT = "SELECT company.* FROM company_db.company LEFT JOIN address ON company.ynn = address.ynn where district=:district";
    private static final String FILTER_BY_ABBREVIATION = "SELECT * FROM company where name like ";
    private static final String SEARCH_BY_NAME = "SELECT * FROM company where name or full_name like ";
    private static final String GET_BETWEEN_ID = "SELECT * FROM company_db.company where id between :first_id and :second_id";

    @Override
    public List<Company> getAll() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL).addEntity(Company.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try {
            Company company = session.find(Company.class, id);
            session.remove(company);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Company getCompany(Integer ynn) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_COMPANY).addEntity(Company.class);
            query.setParameter("ynn", ynn);
            return (Company) query.getSingleResult();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Company> getSortedById() throws DaoException {
        try {
            Criteria criteria = session.createCriteria(Company.class, "company");
            criteria.addOrder(Order.asc("id"));
            return criteria.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
    //My modification

    public String joinsGenerator(String[] parameters, String[] statuses, String[] types, String[] values, String createQuery){
        for (int i=0;i<parameters.length;i++){
            if (!parameters[i].substring(0, parameters[i].indexOf(".")).equals("company")){
                if (parameters[i]!=null && statuses[i].equals("sort") && types[i]!=null)
                    createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on company.ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
                if (parameters[i]!=null && (statuses[i].equals("morethan") || statuses[i].equals("lessthan") || statuses[i].equals("equal")) && values[i]!="")
                    createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on company.ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
                if (parameters[i]!=null && (statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("isnull")))
                    createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on company.ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
            }
        }
        return createQuery;
    }

    public String sqlGenForSpecialParameters(String parameter, String status, String type, String sqlQuery){
        System.out.println(1);
        String[] res = parameter.split(" AND ",2);
        System.out.println(2);
        if (parameter!=null && status.equals("min"))
            sqlQuery = sqlQuery + parameter + " = (select min(" + res[1] + ") from " + parameter.substring(0, parameter.indexOf(".")) + " and ";
        if (parameter!=null && status.equals("max"))
            sqlQuery = sqlQuery + parameter + " = (select max(" + res[1] + ") from " + parameter.substring(0, parameter.indexOf(".")) + " and ";
        if (parameter!=null && status.equals("sort") && type!=null)
            sqlQuery = sqlQuery + "order by " + res[1] + " " + type;
        System.out.println(3);
        return sqlQuery;
    }



    public String sqlGeneration(String[] parameters, String[] statuses, String[] types, String[] values, String createQuery){
        for (int i=0; i<parameters.length; i++){
            if (parameters[i]!=null && statuses[i].equals("morethan") && values[i]!="")
                createQuery = createQuery + parameters[i] + " > " + values[i] + " and ";
            if (parameters[i]!=null && statuses[i].equals("lessthan") && values[i]!="")
                createQuery = createQuery + parameters[i] + " < " + values[i] + " and ";
            if (parameters[i]!=null && statuses[i].equals("equal") && values[i]!="")
                createQuery = createQuery + parameters[i] + " = " + values[i] + " and ";
            if (parameters[i].contains(" AND ") && (statuses[i].equals("min") || statuses[i].equals("max"))) {
                createQuery = sqlGenForSpecialParameters(parameters[i], statuses[i], null, createQuery);
                System.out.println("alert");
            }
            if (parameters[i]!=null && !parameters[i].contains(" AND ") && statuses[i].equals("min"))
                createQuery = createQuery + parameters[i] + " = (select min(" + parameters[i] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " and ";
            if (parameters[i]!=null && !parameters[i].contains(" AND ") && statuses[i].equals("max"))
                createQuery = createQuery + parameters[i] + " = (select max(" + parameters[i] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " and ";
            if (parameters[i]!=null && statuses[i].equals("isnull"))
                createQuery = createQuery + parameters[i] + " is null and ";
            if (parameters[i]!=null && statuses[i].equals("sort") && types[i]!=null){
                if (createQuery.substring(createQuery.length()-4, createQuery.length()).equals("and "))
                    createQuery = createQuery.substring(0, createQuery.length()-4);
                if (createQuery.substring(createQuery.length()-6, createQuery.length()).equals("where "))
                    createQuery = createQuery.substring(0, createQuery.length()-6);
                if (parameters[i].contains(" AND "))
                    createQuery = sqlGenForSpecialParameters(parameters[i], statuses[i], types[i], createQuery);
                else
                    createQuery = createQuery + "order by " + parameters[i] + " " + types[i];
            }
        }
        return createQuery;
    }

    public List<Company> getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, int[] operationsCounter) throws DaoException {
        try {
            String createQuery = "SELECT company.* FROM company ";
            createQuery = joinsGenerator(parameters, statuses, types, values, createQuery);
            createQuery = createQuery + "where ";
            createQuery = sqlGeneration(parameters, statuses, types, values, createQuery);
            if (createQuery.substring(createQuery.length()-4, createQuery.length()).equals("and "))
                createQuery = createQuery.substring(0, createQuery.length()-4);
            System.out.println(createQuery);
            Query query = session.createNativeQuery(createQuery).addEntity(Company.class);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    //My modification

    public List<Company> getFilterByArea(String area) throws DaoException {
        try {
            Query query = session.createNativeQuery(FILTER_BY_AREA).addEntity(Company.class);
            query.setParameter("area", area);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Company> getFilterByDistrict(String district) throws DaoException {
        try {
            Query query = session.createNativeQuery(FILTER_BY_DISTRICT).addEntity(Company.class);
            query.setParameter("district", district);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Company> filterByAbbreviation(String text) throws DaoException {
        try {
            Query query = session.createNativeQuery(FILTER_BY_ABBREVIATION + text).addEntity(Company.class);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Company> searchByName(String text) throws DaoException {
        try {
            Query query = session.createNativeQuery(SEARCH_BY_NAME + text).addEntity(Company.class);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Company> getBetweenId(Integer firstId, Integer secondId) throws DaoException {
        try {
            Query query = session.createNativeQuery(GET_BETWEEN_ID).addEntity(Company.class);
            query.setParameter("first_id", firstId);
            query.setParameter("second_id", secondId);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List<Integer> getAllYnn() throws DaoException {
        try {
            return session.createNativeQuery(GET_ALL_YNN).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
