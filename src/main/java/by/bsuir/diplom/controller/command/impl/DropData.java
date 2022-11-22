package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class DropData implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceProvider provider = ServiceProvider.getInstance();
        CompanyService companyService = provider.getCompanyService();

        try {
            companyService.deleteAll();
            session.removeAttribute("companiesList");
            response.sendRedirect("Controller?command=go_to_home_page&message=message.deleteAll.complete");
        } catch (ServiceException e) {
            //userLogger.info(e);
            response.sendRedirect("Controller?command=go_to_home_page&message=message.delete.unsuccessfully");
        }
    }
}
