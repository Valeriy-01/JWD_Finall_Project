package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.tc.finalproject.controller.command.Command;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;

public class DeleteAccount implements Command {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);
	private final static String PASSPORT="passport";
	private final static String INDEX="index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (DAOProvider.getInstance().getUserDAO().isExistUser(request.getParameter(PASSPORT))) {
				DAOProvider.getInstance().getUserDAO().deleteUser(request.getParameter(PASSPORT));
				response.sendRedirect(INDEX);
			} 
		} catch (DAOException e) {
			log.error("Can't logging into account",e);
		}
	}

}
