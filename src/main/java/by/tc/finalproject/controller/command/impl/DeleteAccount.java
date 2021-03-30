package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class DeleteAccount implements Command {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private final static String PASSPORT = "passport";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String DELETE_ACCOUNT = "deleteAccount";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (ServiceProvider.getInstance().getUserService().deleting(request.getParameter(PASSPORT))) {
				HttpSession session = request.getSession();
				session.setAttribute(DELETE_ACCOUNT, 1);
				request.getSession().invalidate();
				response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
			}
		} catch (ServiceException e) {
			log.error("Can't delete account", e);
		}
	}

}
