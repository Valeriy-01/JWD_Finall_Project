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

public class CreateListOfEnrolled implements Command {
	private final static String GO_TO_MAIN_PAGE_COMMAND = "Controller?command=gotomainpage";
	private final static String GO_TO_ADMIN_PAGE_COMMAND = "Controller?command=gotoadminpage";
	private static final String CREATE_ADMISSION_RESULT = "createAdmissionResult";
	private final static String ERROR = "error";


	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ServiceProvider.getInstance().getCommitteeService().formListOfEnrolled();
			session.setAttribute(CREATE_ADMISSION_RESULT, 1);
			response.sendRedirect(GO_TO_ADMIN_PAGE_COMMAND);
		} catch (ServiceException e) {
			session.setAttribute(ERROR, 1);
			response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);
			log.error("Can't create list of enrolle", e);
		}
	}
}
