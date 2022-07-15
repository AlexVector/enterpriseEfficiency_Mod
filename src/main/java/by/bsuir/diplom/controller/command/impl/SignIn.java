package by.bsuir.diplom.controller.command.impl;

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

public class SignIn implements Command {
	private static final Logger userLogger = LogManager.getLogger(SignIn.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		Users user;
		try {
			user = userService.authorization(login, password);
			if (user == null) {
				response.sendRedirect("Controller?command=go_to_sign_in_page&message=message.signIn.incorrect");
				return;
			}
			session.setAttribute("user", user);
			response.sendRedirect("Controller?command=go_to_home_page&message=message.signIn.complete");
		} catch (ServiceException e) {
			userLogger.info(e);
			response.sendRedirect("Controller?command=go_to_sign_in_page&message=message.signIn.incorrect");
		}
	}
}
