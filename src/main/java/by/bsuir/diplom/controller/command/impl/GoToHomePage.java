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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoToHomePage implements Command {
    private static final Logger userLogger = LogManager.getLogger(GoToHomePage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "Controller?command=go_to_home_page");
        if (request.getParameter("message") != null) {
            request.setAttribute("message", request.getParameter("message"));
        }
        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }
        ServiceProvider provider = ServiceProvider.getInstance();
        CompanyService companyService = provider.getCompanyService();
        AddressService addressService = provider.getAddressService();
        try {
            if (session.getAttribute("companiesList") == null) {
                List<Company> companies = companyService.getAll();
                session.setAttribute("companiesList", companies);
            }
            Map<String, List<String>> map = new HashMap<>();
            List<String> areasList = addressService.getAreas();
            for(String area : areasList){
                map.put(area, addressService.getDistrict(area));
            }
            session.setAttribute("locationMap", map);
            session.removeAttribute("companiesIndicators");
            session.removeAttribute("enterpriseIndicators");
            session.removeAttribute("filterCompanies");
            session.removeAttribute("filterArea");
            session.removeAttribute("filterDistrict");
        } catch (ServiceException e) {
            userLogger.error(e);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
