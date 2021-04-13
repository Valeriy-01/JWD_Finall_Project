package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.tc.applicant.controller.command.Command;

public class GoToLoginPage implements Command {
	private static final String PATH_TO_LOGIN_PAGE = "/WEB-INF/jsp/logination.jsp";
	private final static String PATH_TO_ADMIN_PAGE_COMMAND = "Controller?command=gotoadminpage";
	private final static String PATH_TO_PERSONAL_ACCOUNT_COMMAND = "Controller?command=gotopersonpage";

	private final static String USER_SESSION = "userSession";
	private final static String ADMIN_SESSION = "adminSession";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute(USER_SESSION) != null) {
			response.sendRedirect(PATH_TO_PERSONAL_ACCOUNT_COMMAND);
		} else {
			if (session.getAttribute(ADMIN_SESSION) != null) {
				response.sendRedirect(PATH_TO_ADMIN_PAGE_COMMAND);
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_LOGIN_PAGE);
				requestDispatcher.forward(request, response);
			}
		}

	}
}
