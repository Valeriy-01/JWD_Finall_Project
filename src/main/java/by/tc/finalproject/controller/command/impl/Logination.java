package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class Logination implements Command {
	private final static String EMAIL = "email";
	private final static String PASSWORD = "password";
	private final static String PATH_TO_PERSONAL_ACCOUNT = "password";
	private final static String PATH_TO_ADMIN_PAGE = "password";
	private final static String INDEX = "password";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		try {
			if (ServiceProvider.getInstance().getUserService().authorization(email, password)) {
				// fillUserData(email, password, request);
				request.getRequestDispatcher(PATH_TO_PERSONAL_ACCOUNT).forward(request, response);
			}
			if (DAOProvider.getInstance().getCommitteeDAO().isExistCommittee(email, password)) { // сервис для приемной
																									// комисии пока не
																									// написан
				request.getRequestDispatcher(PATH_TO_ADMIN_PAGE).forward(request, response);
			} else {
				response.sendRedirect(INDEX);
			}
		} catch (DAOException e) {
			log.error("Can't get data into dataBase", e);
		} catch (ServiceException e) {
			log.error("Can't logging into account", e);
		}
	}

}
