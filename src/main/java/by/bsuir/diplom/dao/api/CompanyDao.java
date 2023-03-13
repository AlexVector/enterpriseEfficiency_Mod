package by.bsuir.diplom.dao.api;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.dao.exception.DaoException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class CompanyDao extends AbstractDao<Integer, Company> {
    private static final String GET_ALL = "SELECT * FROM company";
    private static final String DELETE_ALL = "DELETE FROM company";
    private static final String GET_ALL_YNN = "SELECT ynn FROM company";
    private static final String GET_COMPANY = "SELECT * FROM company WHERE ynn=:ynn";
    private static final String FILTER_BY_AREA = "SELECT company.* FROM company_db.company LEFT JOIN address ON company.ynn = address.ynn where area=:area";
    private static final String FILTER_BY_DISTRICT = "SELECT company.* FROM company_db.company LEFT JOIN address ON company.ynn = address.ynn where district=:district";
    private static final String FILTER_BY_ABBREVIATION = "SELECT * FROM company where name like ";
    private static final String SEARCH_BY_NAME = "SELECT * FROM company where name or full_name like ";
    private static final String GET_BETWEEN_ID = "SELECT * FROM company_db.company where id between :first_id and :second_id";


    public void deleteAll() throws DaoException {
        try {
            session.createNativeQuery(DELETE_ALL).executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public List getQuerySelectList(String sql_query){
        Query query = session.createNativeQuery(sql_query);
        List listResult = query.list();
        return listResult;
    }

    public List<Company> getQueryCompany(String sql_query) throws DaoException {
        try {
            return session.createNativeQuery(sql_query).addEntity(Company.class).list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public Double getQuerySelectResult(String sql_query) throws DaoException{
        try {
            Query query = session.createNativeQuery(sql_query);
            Double doubleResult = null;
            System.out.println();
            if (query.list().get(0) instanceof Integer){
                List<Integer> result = query.list();
                return Double.valueOf(result.get(0));
            }
            else {
                if (query.list().get(0) instanceof BigInteger){
                    List<BigInteger> biResult = query.list();
                    doubleResult = biResult.get(0).doubleValue();
                    return doubleResult;
                }
                else {
                    if (query.list().get(0) instanceof Double){
                        List<Double> dResult = query.list();
                        doubleResult = dResult.get(0).doubleValue();
                        return doubleResult;
                    }
                    else {
                        List<BigDecimal> bdResult = query.list();
                        doubleResult = bdResult.get(0).doubleValue();
                        return doubleResult;
                    }

                }

            }
        }catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

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

    public String specialJoins(String createQuery, String[] parameters, String[] statuses){
        for (int i=0; i<parameters.length; i++){
            if (parameters[i]!=null && (statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("average")) && !parameters[i].substring(0, parameters[i].indexOf(".")).equals("company")){
                createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on company.ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
            }
        }
        return createQuery + " where ";
    }
    public String standartJoins(String createQuery, String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, boolean has_minmax, String innerJoinConnector){
        for (int i=0;i<parameters.length;i++){
            if (!(statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("average")) && has_minmax && !innerJoinConnector.substring(innerJoinConnector.indexOf(" on "), innerJoinConnector.indexOf(".")).equals(parameters[i].substring(0, parameters[i].indexOf("."))) && !createQuery.contains("join " + parameters[i].substring(0, parameters[i].indexOf("."))+" on"))
                createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + innerJoinConnector + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
            if (!has_minmax && !parameters[i].substring(0, parameters[i].indexOf(".")).equals("company") && !createQuery.contains("join " + parameters[i].substring(0, parameters[i].indexOf("."))+" on")){
                if (parameters[i]!=null && (text_values[i]!="" || (statuses[i].equals("sort") && types[0]!=null) || ((statuses[i].equals("morethan") || statuses[i].equals("lessthan") || statuses[i].equals("equal")) && values[i]!="") || statuses[i].equals("isnull")))
                    createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on company.ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
            }
        }
        return createQuery + " where ";//возможно, where тут будет мешать
    }

    public String commonSQLgen(String createQuery, String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values){
        for (int i=0; i<parameters.length; i++){
            if (parameters[i]!=null){
                if (text_values[i]!="")
                    createQuery = createQuery + parameters[i] + " like '%" + text_values[i] + "%' and ";
                if (statuses[i].equals("morethan") && values[i]!="")
                    createQuery = createQuery + parameters[i] + " > " + values[i] + " and ";
                if (statuses[i].equals("lessthan") && values[i]!="")
                    createQuery = createQuery + parameters[i] + " < " + values[i] + " and ";
                if (statuses[i].equals("equal") && values[i]!="")
                    createQuery = createQuery + parameters[i] + " = " + values[i] + " and ";
                if (statuses[i].equals("isnull"))
                    createQuery = createQuery + parameters[i] + " is null and ";
            }
        }
        for (int i=0; i<parameters.length; i++){
            if (parameters[i]!=null && statuses[i].equals("sort") && types[0]!=null){
                if (createQuery.substring(createQuery.length()-4, createQuery.length()).equals("and "))
                    createQuery = createQuery.substring(0, createQuery.length()-4);
                if (createQuery.substring(createQuery.length()-6, createQuery.length()).equals("where "))
                    createQuery = createQuery.substring(0, createQuery.length()-6);
                if (parameters[i].contains(" AND ")){
                    String[] res = parameters[i].split(" AND ",2);
                    createQuery = createQuery + res[0] + " order by " + res[1] + " " + types[0];
                }
                else {
                    createQuery = createQuery + "order by " + parameters[i] + " " + types[0];
                }
            }
        }
        return createQuery;
    }

    public List<Company> getAdvancedSearchResultList(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, int operationsSum) throws DaoException {
        try {
            String createQuery = "SELECT company.* FROM company ";
            boolean has_minmax = false;
            String innerJoinConnector = null;
            for (int i=0; i<parameters.length; i++){
                if (parameters[i]!=null && (statuses[i].equals("min") || statuses[i].equals("max"))){
                    has_minmax = true;
                    createQuery = specialJoins(createQuery, parameters, statuses);
                    innerJoinConnector = " on " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn = ";
                    if (parameters[i].contains(" AND ")){
                        String[] res = parameters[i].split(" AND ",2);
                        if (parameters[i]!=null && statuses.equals("min"))
                            createQuery = createQuery + parameters[i] + " = (select min(" + res[1] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " ";
                        if (parameters[i]!=null && statuses.equals("max"))
                            createQuery = createQuery + parameters[i] + " = (select max(" + res[1] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " ";
                    }
                    else {
                        if (statuses[i].equals("min"))
                            createQuery = createQuery + parameters[i] + " = (select min(" + parameters[i] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " ";
                        if (statuses[i].equals("max"))
                            createQuery = createQuery + parameters[i] + " = (select max(" + parameters[i] + ") from " + parameters[i].substring(0, parameters[i].indexOf(".")) + " ";
                    }
                }
            }
            createQuery = standartJoins(createQuery, parameters, statuses, types, values, text_values, has_minmax, innerJoinConnector);
            createQuery = commonSQLgen(createQuery, parameters, statuses, types, values, text_values);
            if (createQuery.substring(createQuery.length()-4, createQuery.length()).equals("and "))
                createQuery = createQuery.substring(0, createQuery.length()-4);
            if (createQuery.substring(createQuery.length()-6, createQuery.length()).equals("where "))
                createQuery = createQuery.substring(0, createQuery.length()-6);
            if (has_minmax)
                createQuery = createQuery + ") ";
            //createQuery = createQuery + " COLLATE utf8mb4_general_ci ";
            System.out.println(createQuery);
            Query query = session.createNativeQuery(createQuery).addEntity(Company.class);
            return query.list();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    //переписать под avg
    public Double getAdvancedSearchResult(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values, int operationsSum) throws DaoException {
        try {
            int k = -1;
            String[] res = null;
            for (int i=0; i< statuses.length; i++){
                if (statuses[i].equals("average"))
                    k=i;
            }
            String createQuery = null;
            if (parameters[k].contains(" AND ")){
                res = parameters[k].split(" AND ",2);
                createQuery = "SELECT AVG("+ res[1] + ") FROM "+ parameters[k].substring(0, parameters[k].indexOf(".")) + " ";
            }
            else createQuery = "SELECT  AVG("+ parameters[k] + ") FROM "+ parameters[k].substring(0, parameters[k].indexOf(".")) + " ";

            String innerJoinConnector = " on " + parameters[k].substring(0, parameters[k].indexOf(".")) + ".ynn = ";
            for (int i=0;i<parameters.length;i++){
                if (!(statuses[i].equals("average")) && !innerJoinConnector.substring(innerJoinConnector.indexOf(" on "), innerJoinConnector.indexOf(".")).equals(parameters[i].substring(0, parameters[i].indexOf("."))) && !createQuery.contains("join " + parameters[i].substring(0, parameters[i].indexOf("."))+" on"))
                    createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + innerJoinConnector + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
                if (!parameters[i].substring(0, parameters[i].indexOf(".")).equals(parameters[k].substring(0, parameters[k].indexOf("."))) && !createQuery.contains("join " + parameters[i].substring(0, parameters[i].indexOf("."))+" on")){
                    if (parameters[i]!=null && (text_values[i]!="" || (statuses[i].equals("sort") && types[0]!=null) || ((statuses[i].equals("morethan") || statuses[i].equals("lessthan") || statuses[i].equals("equal")) && values[i]!="") || statuses[i].equals("isnull")))
                        createQuery = createQuery + "join " + parameters[i].substring(0, parameters[i].indexOf(".")) + " on " + parameters[k].substring(0, parameters[k].indexOf(".")) + ".ynn = " + parameters[i].substring(0, parameters[i].indexOf(".")) + ".ynn ";
                }
            }
            createQuery = createQuery + " where ";//возможно, where тут будет мешать
            createQuery = commonSQLgen(createQuery, parameters, statuses, types, values, text_values);
            if (createQuery.substring(createQuery.length()-4, createQuery.length()).equals("and "))
                createQuery = createQuery.substring(0, createQuery.length()-4);
            if (createQuery.substring(createQuery.length()-6, createQuery.length()).equals("where "))
                createQuery = createQuery.substring(0, createQuery.length()-6);
            //createQuery = createQuery + " COLLATE utf8mb4_general_ci ";
            System.out.println(createQuery);
            Query query = session.createNativeQuery(createQuery);
            List<BigDecimal> result = query.list();
            //System.out.println(result.toString());
            return result.get(0).doubleValue();
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
