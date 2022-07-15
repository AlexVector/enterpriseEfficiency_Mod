package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.AddressService;
import by.bsuir.diplom.service.api.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class GoToEditCompanyPage implements Command {
    private static final Logger userLogger = LogManager.getLogger(GoToEditCompanyPage.class);
    private static final String EDIT_COMPANY = "editCompanyYnn";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=go_to_edit_company_page");

        if (request.getParameter(EDIT_COMPANY) != null) {
            session.setAttribute(EDIT_COMPANY, Integer.valueOf(request.getParameter(EDIT_COMPANY)));
        }

        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        Integer editCompanyYnn = Integer.valueOf(request.getParameter(EDIT_COMPANY));

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();

        try {
            Company company = companyService.getCompany(editCompanyYnn);
            session.setAttribute("editCompany", company);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editCompanyPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_home_page&message=message.error.server");
        }
    }
}
