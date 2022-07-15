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

public class EditUser implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditUser.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users previousUser = (Users) session.getAttribute("editUser");
        Users sessionUser = (Users) session.getAttribute("user");

        if (request.getParameter("editRole") != null) {
            previousUser.setRole(UserRole.getByCode(Integer.valueOf(request.getParameter("editRole"))));
        }

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        if (!"".equals(request.getParameter("editOldPassword")) && !"".equals(request.getParameter("editNewPassword"))) {
            String oldPass = request.getParameter("editOldPassword");
            String newPass = request.getParameter("editNewPassword");
            try {
                userService.edit(previousUser, oldPass, newPass);
            } catch (ServiceException e) {
                userLogger.info(e);
                if ("Entered wrong old password".equals(e.getMessage())) {
                    response.sendRedirect("Controller?command=go_to_edit_user_page&message.editUser.unsuccessfully");
                } else {
                    response.sendRedirect("Controller?command=go_to_edit_user_page&message=message.edit.unsuccessfully");
                }
            }
        } else {
            try {
                userService.edit(previousUser);
            } catch (ServiceException e) {
                userLogger.error(e);
                response.sendRedirect("Controller?command=go_to_edit_user_page&message=message.edit.unsuccessfully");
            }
        }
        session.removeAttribute("citiesList");
        session.removeAttribute("editUser");
        session.removeAttribute("userId");
        if (sessionUser.getRole().getValue() == 0) {
            response.sendRedirect("Controller?command=go_to_users_page&message=message.editUser.complete");
        } else {
            try {
                Users user = userService.getUser(sessionUser.getId());
                session.setAttribute("user", user);
            } catch (ServiceException e) {
                userLogger.error(e);
            }
            response.sendRedirect("Controller?command=go_to_user_profile_page&message=message.editUser.complete");
        }
    }
}
