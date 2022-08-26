//My modification
//Special class for advanced search
package by.bsuir.diplom.controller.command.impl;
import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.dao.exception.DaoException;
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

public class AdvancedSearch implements Command {
    private static final Logger userLogger = LogManager.getLogger(AdvancedSearch.class);

    public int[] searchTypesCounter(String[] parameters, String[] statuses, String[] types, String[] values, String[] text_values){
        int[] operationCounter = new int[4];
        if (parameters!=null){
            for (int i=0; i<parameters.length; i++){
                if (text_values[i]!="") operationCounter[0]++;
                if (statuses!=null && statuses[i].equals("sort") && types!=null) operationCounter[1]++;
                if (statuses!=null && (statuses[i].equals("lessthan") || statuses[i].equals("morethan") || statuses[i].equals("equal"))&& values!=null && values[i]!="") operationCounter[2]++;
                if (statuses!=null && (statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("isnull"))) operationCounter[3]++;
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
        if (operationsCounter[0]>0 || operationsCounter[1]>0 || operationsCounter[2]>0 || operationsCounter[3]>0){
            CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
            session.removeAttribute("companiesList");
            try {
                List<Company> advSearchCompanies = companyService.getAdvancedSearchResult(parameters,statuses,types,values,text_values,operationsSum);
                session.setAttribute("advSearchCompanies", advSearchCompanies);
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
