package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.applicant.bean.User;
import by.tc.applicant.controller.command.Command;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.service.ServiceProvider;
import by.tc.applicant.service.exception.ServiceException;

public class Logination implements Command {
	private final static String USER = "user";
	private final static String EMAIL = "email";
	private final static String PASSWORD = "password";
	private final static String PATH_TO_ADMIN_PAGE_COMMAND = "Controller?command=gotoadminpage";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String PATH_TO_PERSONAL_ACCOUNT_COMMAND = "Controller?command=gotopersonpage";
	private final static String ERROR = "error";
	private final static String LOGIN = "login";

	private final static String USER_SESSION = "userSession";
	private final static String ADMIN_SESSION = "adminSession";

	private final static int userIdentify = 1;
	private final static int adminIdentify = 0;

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		HttpSession session = request.getSession();

		try {
			User user = ServiceProvider.getInstance().getUserService().authorization(email, password);
			if (user != null) {
				session.setAttribute(USER, user);
				session.setAttribute(USER_SESSION, userIdentify);
				response.sendRedirect(PATH_TO_PERSONAL_ACCOUNT_COMMAND);
			} else {
				if (ServiceProvider.getInstance().getCommitteeService().authorization(email, password)) {
					session.setAttribute(ADMIN_SESSION, adminIdentify);
					response.sendRedirect(PATH_TO_ADMIN_PAGE_COMMAND);
				} else {
					session.setAttribute(LOGIN, 1);
					response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
				}
			}
		} catch (ServiceException e) {
			log.error("Can't logging into account", e);
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
		}
	}

}
