package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class DeleteAccountFromAdmin implements Command {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private final static String PASSPORT = "passport";
	private final static String GO_TO_LIST_OF_APPLICANTS_COMMAND = "Controller?command=gotolistofapplicants";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (ServiceProvider.getInstance().getCommitteeService().deletingUser(request.getParameter(PASSPORT))) {
				response.sendRedirect(GO_TO_LIST_OF_APPLICANTS_COMMAND);
			}
		} catch (ServiceException e) {
			log.error("Can't delete account from admin", e);
		}
	}
}
