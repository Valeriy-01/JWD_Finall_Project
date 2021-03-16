package by.tc.finalproject.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.bean.TransferUser;
import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;

public class GoToListOfApplicants implements Command {

	private static final String PATH_TO_ENROLLEE_LIST_PAGE = "/WEB-INF/jsp/enrollee-list.jsp";
	private final static String USERS = "users";

	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<TransferUser> transferUsers = DAOProvider.getInstance().getUserDAO().getUsers();
			request.getSession(true).setAttribute(USERS, transferUsers);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_ENROLLEE_LIST_PAGE);
			requestDispatcher.forward(request, response);
		} catch (DAOException e) {
			log.error("Error while getting the list of users");
		}
	}
}
