package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class CheckAdmissionResult implements Command {
	private static final String PATH_TO_PERSON_PAGE = "/WEB-INF/jsp/personal-account.jsp";
	private final static String PASSPORT = "passport";
	private final static String RESULT = "result";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int result = ServiceProvider.getInstance().getUserService().checkEnrolled(request.getParameter(PASSPORT));
			request.setAttribute(RESULT, result);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_PERSON_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			log.error("Can't check admission result", e);
		}
	}
}
