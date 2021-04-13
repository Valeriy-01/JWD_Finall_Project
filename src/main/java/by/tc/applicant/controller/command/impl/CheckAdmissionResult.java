package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.applicant.controller.command.Command;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.service.ServiceProvider;
import by.tc.applicant.service.exception.ServiceException;

public class CheckAdmissionResult implements Command {
	private static final String PATH_TO_PERSON_PAGE = "/WEB-INF/jsp/personal-account.jsp";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String PASSPORT = "passport";
	private final static String RESULT = "result";
	private final static String ERROR = "error";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int result = ServiceProvider.getInstance().getUserService().checkEnrolled(request.getParameter(PASSPORT));
			request.setAttribute(RESULT, result);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_PERSON_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			log.error("Can't check admission result", e);
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);

		}
	}
}
