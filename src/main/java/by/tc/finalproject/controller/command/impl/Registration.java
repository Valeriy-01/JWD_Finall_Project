package by.tc.finalproject.controller.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

import java.io.IOException;

public class Registration implements Command {
	private final static String NAME = "name";
	private final static String SURNAME = "surname";
	private final static String EMAIL = "email";
	private final static String PASSWORD = "password";
	private final static String FIRST_SUBJECT = "sub_1";
	private final static String SECOND_SUBJECT = "sub_2";
	private final static String THIRD_SUBJECT = "sub_3";
	private final static String CERTIFICATE = "certificate";
	private final static String PASSPORT = "passport";
	private final static String FACULTY = "faculty";
	private final static String INDEX = "index.jsp";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User(request.getParameter(NAME), request.getParameter(SURNAME), request.getParameter(PASSPORT));
		UserAccess userAccess = new UserAccess(request.getParameter(EMAIL), request.getParameter(PASSWORD));
		State state = new State(Integer.parseInt(request.getParameter(FIRST_SUBJECT)),
				Integer.parseInt(request.getParameter(SECOND_SUBJECT)),
				Integer.parseInt(request.getParameter(THIRD_SUBJECT)),
				Integer.parseInt(request.getParameter(CERTIFICATE)));
		try {
			ServiceProvider.getInstance().getUserService().registration(user, userAccess, state,
					request.getParameter(FACULTY));
			response.sendRedirect(INDEX);
		} catch (ServiceException e) {
			log.error("Can't create new user", e);
		}
	}

}
