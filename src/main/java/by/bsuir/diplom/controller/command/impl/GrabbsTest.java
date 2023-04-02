package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CompanyDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.GTestResultClass;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GrabbsTest extends SessionUtil implements Command {

    private Map<String, String> options = new HashMap<String, String>(){{
        put("Код ОКПО", "company.okpo");
        put("Код УНН", "company.ynn");
        put("Код отрасли", "company_info.industry_code");
        put("Уровень рентабельности", "coefficients.profitability");
        put("Уровень рентабельности без учета государственной поддержки", "coefficients.profitability_without_support");

        put("Основные средства", "fixed_assets.fixed_assets");
        put("Долгосрочные кредиты и займы", "fixed_assets.loans_borrowings");
        put("ИТОГО по разделу IV", "fixed_assets.total_4");
        put("Краткосрочная кредиторская задолженность", "fixed_assets.shortterm_debt");
        put("ИТОГО по разделу V", "fixed_assets.total_5");
        put("Выручка от реализации товаров, продукции, работ, услуг", "fixed_assets.sales_revenue");
        put("Чистая прибыль", "fixed_assets.profit");
        put("Рентабельность продаж", "sales_return.sales_return");
        put("На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2020 года)", "sales_return.current_dividend_payments");
        put("На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2019 года)", "sales_return.prev_dividend_payments");
        put("Кредиторская задолженность на конец отчетного периода всего", "sales_return.total_end_debt");
        put("Кредиторская задолженность на конец отчетного периода, в том числе просроченная", "sales_return.overdue_end_debt");
        put("Кредиторская задолженность на начало отчетного года всего", "sales_return.total_begin_debt");
        put("Кредиторская задолженность на начало отчетного года, в том числе просроченная", "sales_return.overdue_begin_debt");
        put("Чистые активы на конец отчетного периода", "coefficients.end_net_assets");
        put("Чистые активы на начало отчетного периода", "coefficients.begin_net_assets");
        put("Баланс на 31 декабря 2020 года", "cattle.current_end_balance");
        put("Баланс на 31 декабря 2019 года", "cattle.prev_end_balance");

        put("Коэффициент обеспеченности собственными оборотными средствами", "coefficients.own_security");
        put("Коэффициент текущей ликвидности", "coefficients.current_liquidity");
        put("Коэффициент обеспеченности финансовых обязательств активами", "coefficients.financial_security");
        put("Коэффициент абсолютной ликвидности", "coefficients.absolute_liquidity");

        put("Среднесписочная численность работников (всего, включая наемный персонал в колхозах)", "staff.column_index=107 AND staff.average_number");
        put("Среднесписочная численность работников (персонал основной деят. занятый в с/х производстве)", "staff.column_index=109 AND staff.average_number");
        put("Среднесписочная численность работников (рабочие)", "staff.column_index=111 AND staff.average_number");
        put("Среднесписочная численность работников (служащие)", "staff.column_index=113 AND staff.average_number");
        put("Среднесписочная численность работников (руководители)", "staff.column_index=115 AND staff.average_number");
        put("Среднесписочная численность работников (специалисты)", "staff.column_index=117 AND staff.average_number");
        put("Фонд ЗП работников, вкл. совместителей (всего, вкл. наемный персонал в колхозах)", "staff.column_index=107 AND staff.salary_fund");
        put("Фонд ЗП работников, вкл. совместителей (персонал основной деят. занятый в с/х производстве)", "staff.column_index=109 AND staff.salary_fund");
        put("Фонд ЗП работников, вкл. совместителей (рабочие)", "staff.column_index=111 AND staff.salary_fund");
        put("Фонд ЗП работников, вкл. совместителей (служащие)", "staff.column_index=113 AND staff.salary_fund");
        put("Фонд ЗП работников, вкл. совместителей (руководители)", "staff.column_index=115 AND staff.salary_fund");
        put("Фонд ЗП работников, вкл. совместителей (специалисты)", "staff.column_index=117 AND staff.salary_fund");

        put("Полная себестоимость проданной продукции растениеводства", "crop_production.column_index = 123 AND crop_production.full_cost_price");
        put("Полная себестоимость проданной продукции животноводства", "crop_production.column_index = 127 AND crop_production.full_cost_price");
        put("Полная себестоимость проданной продукции итого", "crop_production.column_index = 129 AND crop_production.full_cost_price");
        put("Выручено с продажи с продажи продукции растениеводства", "crop_production.column_index = 123 AND crop_production.bailed_out");
        put("Выручено с продажи с продажи продукции животноводства", "crop_production.column_index = 127 AND crop_production.bailed_out");
        put("Выручено с продажи с продажи продукции итого", "crop_production.column_index = 129 AND crop_production.bailed_out");

        put("Затраты на оплату труда с отчислениями на социальные нужды", "expenses.labor_cost");
        put("Матеpиальные затpаты, вошедшие в себестоимость пpодукции", "expenses.material_costs");
        put("Коpма (всего)", "expenses.feed");
        put("Корма покупные", "expenses.purchased_feed");
        put("Амоpтизация основных сpедств и нематериальных активов", "expenses.deprecation");
        put("Страховые платежи", "expenses.insurance_payments");
        put("Пpочие затpаты", "expenses.other_costs");
        put("Итого затpат", "expenses.total_costs");
        put("Затраты по закладке и выращиванию молодых многолетних насаждений", "expenses.planting_costs");

        put("Сбор зеpна в физической массе после доpаботки, всего", "grounds.products_index=140 AND grounds.total_products");
        put("Сбор зеpна в физической массе после доpаботки, с 1 га", "grounds.products_index=140 AND grounds.hectare_products");
        put("Себестоимость единицы продукции (зерно)", "grounds.products_index=140 AND grounds.production_cost");
        put("Сбор картофеля, всего", "grounds.products_index=143 AND grounds.total_products");
        put("Сбор картофеля, с 1 га", "grounds.products_index=143 AND grounds.hectare_products");
        put("Себестоимость единицы продукции (картофель)", "grounds.products_index=143 AND grounds.production_cost");
        put("Всего сельскохозяйственных угодий (гектары)", "grounds.products_index=140 AND grounds.hectare");
        put("Всего сельскохозяйственных угодий (баллогектары га)", "grounds.products_index=140 AND grounds.ballogectars");
        put("Пашня (гектары)", "grounds.products_index=143 AND grounds.hectare");
        put("Пашня (баллогектары га)", "grounds.products_index=143 AND grounds.ballogectars");
        put("КРС. Молочного направления основное стадо молочного скота", "dairy_products.cattle");
        put("Молоко тонн (Выход продукции количество)", "dairy_products.output_dairy_products");
        put("Молоко тонн (Себестоимость единицы продукции)", "dairy_products.cost_dairy_products");
        put("Пpиpост тонн (Выход продукции количество)", "dairy_products.production_growth");
        put("Пpиpост тонн (Себестоимость единицы продукции)", "dairy_products.production_cost_growth");
        put("Сpеднегодовой удой молока от одной коpовы", "cattle.milk_yield");
        put("Сpеднесуточный пpиpост кpупного pогатого скота - всего", "cattle.average_daily_increase");
        put("Коровы и быки-производители(кроме рабочего скота). Расход кормов на единицу продукции", "cattle.cattle_producers");
        put("Крупный рогатый скот на выpащивании и откоpме всего. Расход кормов на единицу продукции", "cattle.cattle_cultivation");
    }};

    public List<GTestResultClass> grabbsFullTest() throws DaoException {
        List<GTestResultClass> resultList = new ArrayList<GTestResultClass>();
        Set<Map.Entry<String, String>> entrySet = options.entrySet();
        for (Map.Entry<String,String> pair : entrySet) {
            List<GTestResultClass> gTestResultClassList = grabbsSelectedTest(pair.getValue());
            if (gTestResultClassList != null)
                for (GTestResultClass gtr: gTestResultClassList)
                    resultList.add(gtr);
        }
        return resultList;
    }

    public List<GTestResultClass> grabbsSelectedTest(String parameter) throws DaoException {
        //Double max = find(parameter, "MAX");
        //Double min = find(parameter, "MIN");
        //Double avg = find(parameter, "AVG");
        //Double count = find(parameter, "COUNT");
        List listResult = findList(parameter);
        Double alpha = 0.05;
        List<Double> doubleListResult = new ArrayList<>();
        for (int i = 0; i < listResult.size(); i++){
            if (listResult.get(i) instanceof Integer)
                doubleListResult.add(((Integer) listResult.get(i)).doubleValue());
            else
                doubleListResult.add((Double) listResult.get(i));
        }
        List<Double> anomaly = grubbsFunction(doubleListResult, alpha);
        //System.out.println(anomaly);
        //System.out.println(anomaly.size());
        List<Company> companyList = findCompanyFullList(parameter);

        String parameter_name = null;
        Set<Map.Entry<String, String>> entrySet = options.entrySet();
        List <GTestResultClass> testResult = new ArrayList<GTestResultClass>();
        for (Map.Entry<String,String> pair : entrySet) {
            if (parameter.equals(pair.getValue())) {
                parameter_name = pair.getKey();// нашли наше значение и возвращаем ключ
                break;
            }
        }

        if (anomaly.size() > 0){
            for (int i = 0; i < anomaly.size(); i++){
                testResult.add(new GTestResultClass(companyList.get(i), parameter_name, String.valueOf(anomaly.get(i)),"Подозрительно большое значение"));
            }
        }
        List<Company> companyNullAnomalyList = findNullParamCompanyList(parameter);
        if (companyNullAnomalyList.size() > 0){
            for (Company nullCompany: companyNullAnomalyList)
                testResult.add(new GTestResultClass(nullCompany, parameter_name, "0", "Значение отсутствует"));
        }
        if (testResult.size() > 0)
            return testResult;
        else
            return null;

        /*
        Double st_dev_part = Double.valueOf(0);
        for (int i = 0; i < count.intValue(); i++){
            if (listResult.get(i) != null && listResult.get(i) instanceof Double)
                st_dev_part = st_dev_part + Math.pow((Double.valueOf((Double) listResult.get(i)) - avg), 2);//ошибки приведения d к i и i к d
            else if (listResult.get(i) != null)
                st_dev_part = st_dev_part + Math.pow((Integer.valueOf((Integer) listResult.get(i)) - avg), 2);
        }
        Double standart_deviation = Math.sqrt(st_dev_part/(count-1));
        Double G = (max - min)/standart_deviation;
        Double alpha = 0.05;
        Double significance_value = alpha/count;//уровень значимости
        Double degrees_of_freedom = count - 2;//степени свободы
        Double t_crit_value = new org.apache.commons.math3.distribution.TDistribution(degrees_of_freedom).inverseCumulativeProbability(1-significance_value);
        Double g_crit_value = ((count-1)*t_crit_value)/(Math.sqrt(count*(degrees_of_freedom+Math.pow(t_crit_value, 2))));
        //System.out.println(max + "---" + min + "---" + avg + "---" + count + "---" + standart_deviation +
                //"---" + degrees_of_freedom + "---" + t_crit_value + "---" + G + "---" + g_crit_value);
        if (G>g_crit_value){
            List<Company> anomaly_company = findAnomalyCompany(parameter);
            if (anomaly_company != null && anomaly_company.size() > 0){
                Set<Map.Entry<String, String>> entrySet = options.entrySet();
                String parameter_name = null;
                List <GTestResultClass> testResult = new ArrayList<GTestResultClass>();
                for (Map.Entry<String,String> pair : entrySet) {
                    if (parameter.equals(pair.getValue())) {
                        parameter_name = pair.getKey();// нашли наше значение и возвращаем ключ
                        break;
                    }
                }
                testResult.add(new GTestResultClass(anomaly_company.get(0), parameter_name, String.valueOf(max),"Подозрительно большое значение"));

                return testResult;
            }
            else return null;
        }
        else return null;
         */

    }

    public List<Company> findAnomalyCompany(String parameter){
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        openTransactionSession();
        companyDao.setSession(getSession());
        String sql_query = "";
        if (parameter.contains(" AND ")){
            String[] res = parameter.split(" AND ",2);
            sql_query = "SELECT company.* FROM company JOIN " + res[1].substring(0, res[1].indexOf(".")) +
                    " ON company.ynn = " + res[1].substring(0, res[1].indexOf(".")) + ".ynn WHERE " + res[0] +
                    " AND " + res[1] + "=(SELECT MAX(" + res[1] + ") FROM " + res[1].substring(0, res[1].indexOf(".")) + ")";
        }
        else sql_query = "SELECT company.* FROM company JOIN " + parameter.substring(0, parameter.indexOf(".")) +
                " ON company.ynn = " + parameter.substring(0, parameter.indexOf(".")) + ".ynn WHERE " + parameter +
                "=(SELECT MAX(" + parameter + ") FROM " + parameter.substring(0, parameter.indexOf(".")) + ")";
        List<Company> find_result_company = null;
        try {
            find_result_company = companyDao.getQueryCompany(sql_query);
            closeSession();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return find_result_company;
    }

    public List<Company> findCompanyFullList(String parameter){
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        openTransactionSession();
        companyDao.setSession(getSession());
        String sql_query = "";
        if (parameter.contains(" AND ")){
            String[] res = parameter.split(" AND ",2);
            sql_query = "SELECT company.* FROM company JOIN " + res[1].substring(0, res[1].indexOf(".")) +
                    " ON company.ynn = " + res[1].substring(0, res[1].indexOf(".")) + ".ynn WHERE " + res[0] + " ORDER BY " + res[1] + "  DESC";
        }
        else sql_query = "SELECT company.* FROM company JOIN " + parameter.substring(0, parameter.indexOf(".")) +
                " ON company.ynn = " + parameter.substring(0, parameter.indexOf(".")) + ".ynn ORDER BY " + parameter + "  DESC";
        List<Company> find_result_company = null;
        try {
            find_result_company = companyDao.getQueryCompany(sql_query);
            closeSession();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return find_result_company;
    }


    public static List<Double> grubbsFunction(List<Double> values, double alpha) {
        int anom_flag = 0;
        List<Double> outliers = new ArrayList<>();
        while (anom_flag == 0){
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double value : values) {
                if (value != null)
                    stats.addValue(value);
            }
            double mean = stats.getMean();
            double stdDev = stats.getStandardDeviation();
            int n = values.size();
            double maxDeviation = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (values.get(i)!=null){
                    double deviation = Math.abs(values.get(i) - mean);
                    if (deviation > maxDeviation) {
                        maxDeviation = deviation;
                        maxIndex = i;
                    }
                }
            }
            double testStatistic = maxDeviation / stdDev;
            TDistribution tDist = new TDistribution(n - 2);
            double criticalValue = tDist.inverseCumulativeProbability(1 - alpha / (2 * n));
            criticalValue = (n - 1) * criticalValue / Math.sqrt(n * (n - 2 + criticalValue * criticalValue));
            //System.out.println("Grubbs' Test Statistic: " + testStatistic);
            //System.out.println("Critical Value: " + criticalValue);

            if (testStatistic > criticalValue) {
                //System.out.println("Outlier detected: " + values.get(maxIndex));
                outliers.add(values.get(maxIndex));
                values.remove(maxIndex);
                anom_flag = 0;
            }
            else anom_flag = 1;
        }
        return outliers;
    }


    public List<Company> findNullParamCompanyList(String parameter){
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        openTransactionSession();
        companyDao.setSession(getSession());
        String sql_query = "";
        if (parameter.contains(" AND ")){
            String[] res = parameter.split(" AND ",2);
            sql_query = "SELECT company.* FROM company JOIN " + res[1].substring(0, res[1].indexOf(".")) +
                    " ON company.ynn = " + res[1].substring(0, res[1].indexOf(".")) + ".ynn WHERE " + res[0] + " AND " + res[1] + " IS NULL";
        }
        else sql_query = "SELECT company.* FROM company JOIN " + parameter.substring(0, parameter.indexOf(".")) +
                " ON company.ynn = " + parameter.substring(0, parameter.indexOf(".")) + ".ynn WHERE " + parameter + " IS NULL";
        List<Company> find_result_company = null;
        try {
            find_result_company = companyDao.getQueryCompany(sql_query);
            closeSession();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return find_result_company;
    }


    public List findList(String parameter){
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        openTransactionSession();
        companyDao.setSession(getSession());
        String sql_query = "";
        if (parameter.contains(" AND ")){
            String[] res = parameter.split(" AND ",2);
            sql_query = "SELECT " + res[1] + " FROM " + res[1].substring(0, res[1].indexOf(".")) + " WHERE " + res[0];
        }
        else sql_query = "SELECT " + parameter + " FROM " + parameter.substring(0, parameter.indexOf("."));
        List find_result = companyDao.getQuerySelectList(sql_query);
        closeSession();
        return find_result;
    }

    public Double find(String parameter, String func_type){
        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        openTransactionSession();
        companyDao.setSession(getSession());

        String sql_query = "SELECT " + func_type + "(";
        if (parameter.contains(" AND ")){
            String[] res = parameter.split(" AND ",2);
            sql_query = sql_query + res[1] + ") FROM " + res[1].substring(0, res[1].indexOf(".")) + " WHERE " + res[0];
        }
        else sql_query = sql_query + parameter + ") FROM " + parameter.substring(0, parameter.indexOf("."));
        Double find_result = null;
        try {
            find_result = companyDao.getQuerySelectResult(sql_query);
            closeSession();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return find_result;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=anomalies_search");
        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }

        String type = request.getParameter("anomaly");
        String category = request.getParameter("anomcat");
        String parameter = request.getParameter("anomparam");
        if (type.equals("one")){
            if (!category.equals("") && category != null && !parameter.equals("") && parameter != null){
                List<GTestResultClass> testResult = null;
                try {
                    testResult = grabbsSelectedTest(parameter);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                //System.out.println(testResult);
                session.removeAttribute("anomalyResult");
                if (testResult != null){
                    session.setAttribute("anomalyResult", testResult);
                }
            }
        }
        else {
            List<GTestResultClass> testResult = null;
            try {
                testResult = grabbsFullTest();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            session.removeAttribute("anomalyResult");
            if (testResult != null){
                session.setAttribute("anomalyResult", testResult);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/grabbsResultPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
