package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
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

public class GoToCompanyPage implements Command {
    private static final Logger userLogger = LogManager.getLogger(GoToCompanyPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=go_to_company_page&companyYnn=" + request.getParameter("companyYnn"));

        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        Integer ynn = Integer.valueOf(request.getParameter("companyYnn"));

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
        CalcIndicators calcIndicators = new CalcIndicators();
        try {
            Company company = companyService.getCompany(ynn);
            Double enterpriseEfficiency = calcIndicators.calcEnterpriseEfficiency(company);
            session.setAttribute("companyInfo", company);
            session.setAttribute("enterpriseEfficiency", enterpriseEfficiency);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/companyPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_home_page&message=message.error.server");
        }
    }
}
