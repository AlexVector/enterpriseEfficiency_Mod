package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class DeleteCompany implements Command {
    private static final Logger userLogger = LogManager.getLogger(DeleteCompany.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer ynn = Integer.valueOf(request.getParameter("deleteCompanyYnn"));

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();

        try {
            companyService.delete(ynn);
            session.removeAttribute("companiesList");
            response.sendRedirect("Controller?command=go_to_home_page&message=message.deleteCompany.complete");
        } catch (ServiceException e) {
            userLogger.info(e);
            response.sendRedirect("Controller?command=go_to_home_page&message=message.delete.unsuccessfully");
        }
    }
}
