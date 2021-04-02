package by.tc.finalproject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

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

public class GoToListOfApplicants implements Command {

	private static final String PATH_TO_ENROLLEE_LIST_PAGE = "/WEB-INF/jsp/enrollee-list.jsp";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String USERS = "users";
	private final static String ERROR = "error";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<User> users = ServiceProvider.getInstance().getCommitteeService().viewApplicants();
			session.setAttribute(USERS, users);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_ENROLLEE_LIST_PAGE);
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
			log.error("Error while getting the list of users");
		}
	}
}
