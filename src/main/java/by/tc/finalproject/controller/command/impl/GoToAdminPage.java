package by.tc.finalproject.controller.command.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.finalproject.controller.command.Command;

import java.io.IOException;

public class GoToAdminPage implements Command{
	private final static String PATH_TO_ADMIN_PAGE = "WEB-INF/jsp/admin.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_ADMIN_PAGE);
		requestDispatcher.forward(request, response);
	}
}
