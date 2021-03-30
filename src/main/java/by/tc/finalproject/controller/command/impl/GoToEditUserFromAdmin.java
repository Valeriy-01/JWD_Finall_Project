package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.finalproject.bean.User;
import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class GoToEditUserFromAdmin implements Command {
	private static final String PATH_TO_EDIT_FROM_ADMIN_PAGE = "/WEB-INF/jsp/editUserFromAdmin.jsp";
	private final static String OLD_PASSPORT = "oldPassport";
	private final static String PASSPORT = "passport";
	private final static String USER = "user";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = ServiceProvider.getInstance().getCommitteeService().selectUser(request.getParameter(PASSPORT));
			HttpSession session = request.getSession();
			session.setAttribute(USER, user);
			request.setAttribute(OLD_PASSPORT, request.getParameter(PASSPORT));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_EDIT_FROM_ADMIN_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			log.error("Cant't edit user data from admin", e);
		}
	}
}
