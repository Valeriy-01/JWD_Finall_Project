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
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String PASSPORT = "passport";
	private final static String USER = "user";
	private final static String ERROR = "error";


	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			User user = ServiceProvider.getInstance().getCommitteeService().selectUser(request.getParameter(PASSPORT));
			session.setAttribute(USER, user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_EDIT_FROM_ADMIN_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			log.error("Cant't edit user data from admin", e);
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
		}
	}
}
