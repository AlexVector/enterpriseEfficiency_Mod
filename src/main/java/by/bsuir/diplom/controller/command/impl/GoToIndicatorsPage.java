package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.EnterpriseIndicators;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CompanyService;
import by.bsuir.diplom.service.calc.CalcIndicators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GoToIndicatorsPage implements Command {
    private static final Logger userLogger = LogManager.getLogger(GoToIndicatorsPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=go_to_indicators_page");
        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
        CalcIndicators calcIndicators = new CalcIndicators();
        try {
            if (session.getAttribute("companiesIndicators") == null && session.getAttribute("enterpriseIndicators")==null) {
                List<Company> companies = companyService.calcIndicators();
                List<EnterpriseIndicators> indicators = calcIndicators.calcIndicators(companies);
                session.setAttribute("enterpriseIndicators", indicators);
                session.setAttribute("companiesIndicators", companies);
            }
            session.removeAttribute("companiesList");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/indicatorsPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_home_page&message=message.error.server");
        }
    }
}
