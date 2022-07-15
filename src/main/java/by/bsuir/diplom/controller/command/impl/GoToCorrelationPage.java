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
import java.util.List;

public class GoToCorrelationPage implements Command {
    private static final Logger userLogger = LogManager.getLogger(GoToCorrelationPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=go_to_correlation_page&companyYnn=" + request.getParameter("companyYnn"));

        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        Integer ynn = Integer.valueOf(request.getParameter("companyYnn"));

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
        try {
            List<String> companyCorrelation = companyService.calcCorrelation(ynn);
            session.setAttribute("companyCorrelation", companyCorrelation);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/correlationPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_indicators_page&message=message.error.server");
        }
    }
}
