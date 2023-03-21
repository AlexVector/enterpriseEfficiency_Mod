//My modification
//Special class for advanced search
package by.bsuir.diplom.controller.command.impl;
import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.service.OptionDataKeeper;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AdvancedSearch implements Command {
    private static final Logger userLogger = LogManager.getLogger(AdvancedSearch.class);

    private OptionDataKeeper[] optionDataKeeper = {
            new OptionDataKeeper("Наименование", "company.name", "содержит в себе", ""),
            new OptionDataKeeper("Полное наименование", "company.full_name", "содержит в себе", ""),
            new OptionDataKeeper("Адрес", "address.address", "содержит в себе", ""),
            new OptionDataKeeper("Вид деятельности", "company.activity_type", "содержит в себе", ""),
            new OptionDataKeeper("Наименование района", "address.district", "содержит в себе", ""),
            new OptionDataKeeper("Наименование области", "address.area", "содержит в себе", ""),
            new OptionDataKeeper("Наименование отрасли", "company_info.industry_name", "содержит в себе", ""),
            new OptionDataKeeper("Наименование управления", "company_info.department_name", "содержит в себе", ""),
            new OptionDataKeeper("Наименование объединения", "company_info.association_name", "содержит в себе", ""),
            new OptionDataKeeper("Наименование вида собственности", "company_info.ownership_type", "содержит в себе", ""),

            new OptionDataKeeper("Код ОКПО", "company.okpo", "", ""),
            new OptionDataKeeper("Код УНН", "company.ynn", "", ""),
            new OptionDataKeeper("Код отрасли", "company_info.industry_code", "", ""),
            new OptionDataKeeper("Уровень рентабельности", "coefficients.profitability", "", "%"),
            new OptionDataKeeper("Уровень рентабельности без учета государственной поддержки", "coefficients.profitability_without_support", "", "%"),

            new OptionDataKeeper("Основные средства", "fixed_assets.fixed_assets", "", "руб."),
            new OptionDataKeeper("Долгосрочные кредиты и займы", "fixed_assets.loans_borrowings", "", "руб."),
            new OptionDataKeeper("ИТОГО по разделу IV", "fixed_assets.total_4", "", "руб."),
            new OptionDataKeeper("Краткосрочная кредиторская задолженность", "fixed_assets.shortterm_debt", "", "руб."),
            new OptionDataKeeper("ИТОГО по разделу V", "fixed_assets.total_5", "содержит в себе", "руб."),
            new OptionDataKeeper("Выручка от реализации товаров, продукции, работ, услуг", "fixed_assets.sales_revenue", "", "руб."),
            new OptionDataKeeper("Чистая прибыль", "fixed_assets.profit", "", "руб."),
            new OptionDataKeeper("Рентабельность продаж", "sales_return.sales_return", "", "руб."),
            new OptionDataKeeper("На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2020 года)", "sales_return.current_dividend_payments", "", "руб."),
            new OptionDataKeeper("На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2019 года)", "sales_return.prev_dividend_payments", "", "руб."),
            new OptionDataKeeper("Кредиторская задолженность на конец отчетного периода всего", "sales_return.total_end_debt", "", "руб."),
            new OptionDataKeeper("Кредиторская задолженность на конец отчетного периода, в том числе просроченная", "sales_return.overdue_end_debt", "", "руб."),
            new OptionDataKeeper("Кредиторская задолженность на начало отчетного года всего", "sales_return.total_begin_debt", "", "руб."),
            new OptionDataKeeper("Кредиторская задолженность на начало отчетного года, в том числе просроченная", "sales_return.overdue_begin_debt", "", "руб."),
            new OptionDataKeeper("Чистые активы на конец отчетного периода", "coefficients.end_net_assets", "", "руб."),
            new OptionDataKeeper("Чистые активы на начало отчетного периода", "coefficients.begin_net_assets", "", "руб."),
            new OptionDataKeeper("Баланс на 31 декабря 2020 года", "cattle.current_end_balance", "", "руб."),
            new OptionDataKeeper("Баланс на 31 декабря 2019 года", "cattle.prev_end_balance", "", "руб."),

            new OptionDataKeeper("Коэффициент обеспеченности собственными оборотными средствами", "coefficients.own_security", "", ""),
            new OptionDataKeeper("Коэффициент текущей ликвидности", "coefficients.current_liquidity", "", ""),
            new OptionDataKeeper("Коэффициент обеспеченности финансовых обязательств активами", "coefficients.financial_security", "", ""),
            new OptionDataKeeper("Коэффициент абсолютной ликвидности", "coefficients.absolute_liquidity", "", ""),

            new OptionDataKeeper("Среднесписочная численность работников (всего, включая наемный персонал в колхозах)", "staff.column_index=107 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Среднесписочная численность работников (персонал основной деят. занятый в с/х производстве)", "staff.column_index=109 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Среднесписочная численность работников (рабочие)", "staff.column_index=111 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Среднесписочная численность работников (служащие)", "staff.column_index=113 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Среднесписочная численность работников (руководители)", "staff.column_index=115 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Среднесписочная численность работников (специалисты)", "staff.column_index=117 AND staff.average_number", "", "чел."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (всего, вкл. наемный персонал в колхозах)", "staff.column_index=107 AND staff.salary_fund", "", "млн. руб."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (персонал основной деят. занятый в с/х производстве)", "staff.column_index=109 AND staff.salary_fund", "", "млн. руб."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (рабочие)", "staff.column_index=111 AND staff.salary_fund", "", "млн. руб."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (служащие)", "staff.column_index=113 AND staff.salary_fund", "", "млн. руб."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (руководители)", "staff.column_index=115 AND staff.salary_fund", "", "млн. руб."),
            new OptionDataKeeper("Фонд ЗП работников, вкл. совместителей (специалисты)", "staff.column_index=117 AND staff.salary_fund", "", "млн. руб."),

            new OptionDataKeeper("Полная себестоимость проданной продукции растениеводства", "crop_production.column_index = 123 AND crop_production.full_cost_price", "", "руб."),
            new OptionDataKeeper("Полная себестоимость проданной продукции животноводства", "crop_production.column_index = 127 AND crop_production.full_cost_price", "", "руб."),
            new OptionDataKeeper("Полная себестоимость проданной продукции итого", "crop_production.column_index = 129 AND crop_production.full_cost_price", "", "руб."),
            new OptionDataKeeper("Выручено с продажи с продажи продукции растениеводства", "crop_production.column_index = 123 AND crop_production.bailed_out", "", "руб."),
            new OptionDataKeeper("Выручено с продажи с продажи продукции животноводства", "crop_production.column_index = 127 AND crop_production.bailed_out", "", "руб."),
            new OptionDataKeeper("Выручено с продажи с продажи продукции итого", "crop_production.column_index = 129 AND crop_production.bailed_out", "", "руб."),

            new OptionDataKeeper("Затраты на оплату труда с отчислениями на социальные нужды", "expenses.labor_cost", "", "руб."),
            new OptionDataKeeper("Матеpиальные затpаты, вошедшие в себестоимость пpодукции", "expenses.material_costs", "", "руб."),
            new OptionDataKeeper("Коpма (всего)", "expenses.feed", "", "руб."),
            new OptionDataKeeper("Корма покупные", "expenses.purchased_feed", "", "руб."),
            new OptionDataKeeper("Амоpтизация основных сpедств и нематериальных активов", "expenses.deprecation", "", "руб."),
            new OptionDataKeeper("Страховые платежи", "expenses.insurance_payments", "", "руб."),
            new OptionDataKeeper("Пpочие затpаты", "expenses.other_costs", "", "руб."),
            new OptionDataKeeper("Итого затpат", "expenses.total_costs", "", "руб."),
            new OptionDataKeeper("Затраты по закладке и выращиванию молодых многолетних насаждений", "expenses.planting_costs", "", "руб."),

            new OptionDataKeeper("Сбор зеpна в физической массе после доpаботки, всего", "grounds.products_index=140 AND grounds.total_products", "", "т."),
            new OptionDataKeeper("Сбор зеpна в физической массе после доpаботки, с 1 га", "grounds.products_index=140 AND grounds.hectare_products", "", "т."),
            new OptionDataKeeper("Себестоимость единицы продукции (зерно)", "grounds.products_index=140 AND grounds.production_cost", "", "т."),
            new OptionDataKeeper("Сбор картофеля, всего", "grounds.products_index=143 AND grounds.total_products", "", "т."),
            new OptionDataKeeper("Сбор картофеля, с 1 га", "grounds.products_index=143 AND grounds.hectare_products", "", "т."),
            new OptionDataKeeper("Себестоимость единицы продукции (картофель)", "grounds.products_index=143 AND grounds.production_cost", "", "т."),
            new OptionDataKeeper("Всего сельскохозяйственных угодий (гектары)", "grounds.products_index=140 AND grounds.hectare", "", "га."),
            new OptionDataKeeper("Всего сельскохозяйственных угодий (баллогектары га)", "grounds.products_index=140 AND grounds.ballogectars", "", "га."),
            new OptionDataKeeper("Пашня (гектары)", "grounds.products_index=143 AND grounds.hectare", "", "га."),
            new OptionDataKeeper("Пашня (баллогектары га)", "grounds.products_index=143 AND grounds.ballogectars", "", "га."),
            new OptionDataKeeper("КРС. Молочного направления основное стадо молочного скота", "dairy_products.cattle", "", "т."),
            new OptionDataKeeper("Молоко тонн (Выход продукции количество)", "dairy_products.output_dairy_products", "", "т."),
            new OptionDataKeeper("Молоко тонн (Себестоимость единицы продукции)", "dairy_products.cost_dairy_products", "", "руб."),
            new OptionDataKeeper("Пpиpост тонн (Выход продукции количество)", "dairy_products.production_growth", "", "т."),
            new OptionDataKeeper("Пpиpост тонн (Себестоимость единицы продукции)", "dairy_products.production_cost_growth", "", "руб."),
            new OptionDataKeeper("Сpеднегодовой удой молока от одной коpовы", "cattle.milk_yield", "", "т."),
            new OptionDataKeeper("Сpеднесуточный пpиpост кpупного pогатого скота - всего", "cattle.average_daily_increase", "", "т."),
            new OptionDataKeeper("Коровы и быки-производители(кроме рабочего скота). Расход кормов на единицу продукции", "cattle.cattle_producers", "", "кормо-единиц"),
            new OptionDataKeeper("Крупный рогатый скот на выpащивании и откоpме всего. Расход кормов на единицу продукции", "cattle.cattle_cultivation", "", "кормо-единиц")
    };

    public int[] searchTypesCounter(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values){
        int[] operationCounter = new int[4];
        if (parameters!=null){
            for (int i=0; i<parameters.length; i++){
                if (text_values[i]!="") operationCounter[0]++;
                if (statuses!=null && statuses[i].equals("sort") && types!=null) operationCounter[1]++;
                if (statuses!=null && (statuses[i].equals("lessthan") || statuses[i].equals("morethan") || statuses[i].equals("equal"))&& values!=null && values[i]!="") operationCounter[2]++;
                if (statuses!=null && (statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("isnull") || statuses[i].equals("average"))) operationCounter[3]++;
            }
        }
        return operationCounter;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String[] text_values = request.getParameterValues("text_value");
        String[] categories = request.getParameterValues("category");
        String[] parameters = request.getParameterValues("parameter");
        String[] statuses = request.getParameterValues("status");
        String[] types = request.getParameterValues("type");
        String[] values = request.getParameterValues("val");

        int[] operationsCounter = new int[4];
        operationsCounter = searchTypesCounter(parameters,statuses,types,values,text_values);
        int operationsSum = 0;
        for (int i=0; i<operationsCounter.length; i++)
            operationsSum = operationsSum + operationsCounter[i];
        //Костыль
        //System.out.println(statuses[0]);
        //for (int i=0; i<parameters.length; i++){
            //if (parameters!=null && text_values[i]!="") statuses[i]="a";
        //}
        //
        boolean has_avg = false;
        int avg_ind = -1;
        int average_result = -1;
        for (int i=0; i<statuses.length; i++){
            if (statuses[i].equals("average")){
                has_avg = true;
                avg_ind = i;
            }
        }


        if (operationsCounter[0]>0 || operationsCounter[1]>0 || operationsCounter[2]>0 || operationsCounter[3]>0){
            CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
            session.removeAttribute("companiesList");
            try {

                if (has_avg){
                    Double advSearchResult = companyService.getAdvancedSearchResult(parameters,statuses,types,values,text_values,operationsSum);
                    String textAnswer = "Среднее значение параметра ";
                    int avg_ind_in_optioDataKeeper = -1;
                    for (int i = 0; i < optionDataKeeper.length; i++){
                        if (optionDataKeeper[i].getEngParameter().equals(parameters[avg_ind])){
                            textAnswer = textAnswer + "\"" + optionDataKeeper[i].getRusParameterName() + "\"";
                            avg_ind_in_optioDataKeeper = i;
                            break;
                        }
                    }
                    if (operationsSum > 1){
                        for (int i=0; i < parameters.length; i++){
                            if (!statuses[i].equals("average")){
                                textAnswer = textAnswer + ", где параметр ";
                                int thisODKIndex = -1;
                                for (int j = 0; j < optionDataKeeper.length; j++){
                                    if (parameters[i].equals(optionDataKeeper[j].getEngParameter()))
                                        thisODKIndex = j;
                                }
                                textAnswer = textAnswer + "\"" + optionDataKeeper[thisODKIndex].getRusParameterName() + "\" ";
                                if (statuses[i].equals("morethan") && text_values[i].equals(""))
                                    textAnswer = textAnswer + "больше чем " + values[i] + " " + optionDataKeeper[thisODKIndex].getParameterFormat();
                                if (statuses[i].equals("lessthan"))
                                    textAnswer = textAnswer + "меньше чем " + values[i] + " " + optionDataKeeper[thisODKIndex].getParameterFormat();
                                if (statuses[i].equals("equal"))
                                    textAnswer = textAnswer + "равен " + values[i] + " " + optionDataKeeper[thisODKIndex].getParameterFormat();
                                if (!text_values[i].equals(""))
                                    textAnswer = textAnswer + optionDataKeeper[thisODKIndex].getParameterPrefix() + " \"" + text_values[i] + "\" " + optionDataKeeper[thisODKIndex].getParameterFormat();
                            }
                        }
                    }
                    textAnswer = textAnswer + " составляет " + advSearchResult + " " + optionDataKeeper[avg_ind_in_optioDataKeeper].getParameterFormat();
                    //Map<String, Double> advSearchResult =
                    session.setAttribute("advSearchResult", textAnswer);
                    session.removeAttribute("advSearchCompanies");
                }
                else {
                    List<Company> advSearchCompanies = companyService.getAdvancedSearchResultList(parameters,statuses,types,values,text_values,operationsSum);
                    session.setAttribute("advSearchCompanies", advSearchCompanies);
                    session.removeAttribute("advSearchResult");
                }
                session.removeAttribute("companiesList");
            } catch (DaoException e) {
                userLogger.error(e);
            }
        }
        //System.out.println(operationsCounter[0]+" "+operationsCounter[1]+" "+operationsCounter[2]+" "+operationsCounter[3]);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
