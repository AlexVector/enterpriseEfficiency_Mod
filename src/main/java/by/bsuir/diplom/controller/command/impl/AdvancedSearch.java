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

    public int[] searchTypesCounter(String[] parameters, String[] statuses, String[] types, String[] values){
        int[] operationCounter = new int[3];
        if (parameters!=null && statuses!=null){
            for (int i=0; i<statuses.length; i++){
                if (statuses[i].equals("sort") && types!=null && types[i]!=null) operationCounter[0]++;
                if ((statuses[i].equals("lessthan") || statuses[i].equals("morethan") || statuses[i].equals("equal"))&& values!=null && values[i]!="") operationCounter[1]++;
                if ((statuses[i].equals("min") || statuses[i].equals("max") || statuses[i].equals("isnull"))) operationCounter[2]++;
            }
        }
        return operationCounter;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String[] categories = request.getParameterValues("category");
        String[] parameters = request.getParameterValues("parameter");
        String[] statuses = request.getParameterValues("status");
        String[] types = request.getParameterValues("type");
        String[] values = request.getParameterValues("val");

        int[] operationsCounter = new int[3];
        operationsCounter = searchTypesCounter(parameters,statuses,types,values);
        //for (int i = 0; i<operationsCounter.length; i++)
            //System.out.println(operationsCounter[i]);
        if (operationsCounter[0]>0 || operationsCounter[1]>0 || operationsCounter[2]>0){
            CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
            session.removeAttribute("companiesList");
            try {
                //session.setAttribute("page", "Controller?command=filter_by_location&filterDistrict=" + district);
                List<Company> advSearchCompanies = companyService.getAdvancedSearchResult(parameters,statuses,types,values,operationsCounter);
                //for (int i=0;i<advSearchCompanies.size();i++)
                    //System.out.println(advSearchCompanies.get(i).getYnn());
                session.setAttribute("advSearchCompanies", advSearchCompanies);
                session.removeAttribute("companiesList");
            } catch (DaoException e) {
                userLogger.error(e);
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
