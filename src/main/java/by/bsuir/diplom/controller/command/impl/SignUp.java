package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.UserRole;
import by.bsuir.diplom.bean.Users;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class SignUp implements Command {
    private static final Logger userLogger = LogManager.getLogger(SignUp.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        String login = request.getParameter("signUpLogin");
        String password = request.getParameter("signUpPassword");
        String confirmPassword = request.getParameter("signUpConfirmPassword");
        UserRole role = UserRole.getByCode(Integer.valueOf(request.getParameter("signUpRole")));

        Users signUpUser = new Users(login, password, role);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        try {
            userService.registration(signUpUser, confirmPassword);
            if (user == null) {
                response.sendRedirect("Controller?command=go_to_sign_in_page&message=message.signUp.complete");
            } else {
                response.sendRedirect("Controller?command=go_to_home_page&message=message.signUp.complete");
            }
        } catch (ServiceException e) {
            userLogger.info(e);
            response.sendRedirect("Controller?command=go_to_sign_up_page&message=message.error.signUp");
        }
    }
}
