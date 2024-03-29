package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.applicant.bean.State;
import by.tc.applicant.bean.User;
import by.tc.applicant.bean.UserAccess;
import by.tc.applicant.controller.command.Command;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.service.ServiceProvider;
import by.tc.applicant.service.exception.ServiceException;

public class Editing implements Command {

	private static final String PATH_TO_PERSON_PAGE = "/WEB-INF/jsp/personal-account.jsp";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String USER = "user";
	private final static String NAME = "name";
	private final static String SURNAME = "surname";
	private final static String EMAIL = "email";
	private final static String PASSWORD = "password";
	private final static String FIRST_SUBJECT = "firstSubjectResult";
	private final static String SECOND_SUBJECT = "secondSubjectResult";
	private final static String THIRD_SUBJECT = "thirdSubjectResult";
	private final static String CERTIFICATE = "certificateResult";
	private final static String PASSPORT = "passport";
	private final static String FACULTY = "facultyTitle";
	private final static String EDIT_ACCOUNT = "editAccount";
	private final static String ERROR = "error";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccess userAccess = new UserAccess(request.getParameter(EMAIL), request.getParameter(PASSWORD));
		State state = new State(Integer.parseInt(request.getParameter(FIRST_SUBJECT)),
				Integer.parseInt(request.getParameter(SECOND_SUBJECT)),
				Integer.parseInt(request.getParameter(THIRD_SUBJECT)),
				Integer.parseInt(request.getParameter(CERTIFICATE)));
		User user = new User(request.getParameter(SURNAME), request.getParameter(NAME), request.getParameter(PASSPORT),
				userAccess, state);
		user.setFacultyTitle(request.getParameter(FACULTY));

		try {
			if (ServiceProvider.getInstance().getUserService().editing(request.getParameter(PASSPORT), user)) {
				session.setAttribute(USER, user);
				session.setAttribute(EDIT_ACCOUNT, 1);
			} else {
				session.setAttribute(EDIT_ACCOUNT, 0);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_PERSON_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			log.error("Can't edit user data", e);
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
		}
	}

}
