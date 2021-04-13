package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.tc.applicant.controller.command.Command;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.service.ServiceProvider;
import by.tc.applicant.service.exception.ServiceException;

public class DeleteAccountFromAdmin implements Command {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private final static String PASSPORT = "passport";
	private final static String GO_TO_LIST_OF_APPLICANTS_COMMAND = "Controller?command=gotolistofapplicants";
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String ERROR = "error";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			if (ServiceProvider.getInstance().getCommitteeService().deletingUser(request.getParameter(PASSPORT))) {
				response.sendRedirect(GO_TO_LIST_OF_APPLICANTS_COMMAND);
			}
		} catch (ServiceException e) {
			log.error("Can't delete account from admin", e);
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);

		}
	}
}
