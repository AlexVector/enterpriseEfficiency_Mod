package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
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
import java.util.List;

public class FilterByLocation implements Command {
    private static final Logger userLogger = LogManager.getLogger(FilterByLocation.class);
    private static final String FILTER_AREA = "filterArea";
    private static final String FILTER_DISTRICT = "filterDistrict";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String area = request.getParameter(FILTER_AREA);
        String district = request.getParameter(FILTER_DISTRICT);

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
        session.removeAttribute("companiesList");
        if (request.getParameter(FILTER_AREA) != null) {
            session.setAttribute(FILTER_AREA, request.getParameter(FILTER_AREA));
        }
        if (request.getParameter(FILTER_DISTRICT) != null) {
            session.setAttribute(FILTER_DISTRICT, request.getParameter(FILTER_DISTRICT));
        }
        try {
            if (area == null || "".equals(area)) {
                session.setAttribute("page", "Controller?command=filter_by_location&filterDistrict=" + district);
                List<Company> filterCompanies = companyService.getFilterByDistrict(district);
                session.setAttribute("filterCompanies", filterCompanies);
                session.setAttribute(FILTER_DISTRICT, district);
                session.removeAttribute(FILTER_AREA);
            } else {
                session.setAttribute("page", "Controller?command=filter_area&filterArea=" + area);
                List<Company> filterCompanies = companyService.getFilterByArea(area);
                session.setAttribute("filterCompanies", filterCompanies);
                session.setAttribute(FILTER_AREA, area);
                session.removeAttribute(FILTER_DISTRICT);
            }
            session.removeAttribute("companiesList");
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
