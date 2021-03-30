package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.finalproject.controller.command.Command;

public class Exit implements Command {
	private static final String PATH_TO_MAIN_PAGE = "/WEB-INF/jsp/main.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_MAIN_PAGE);
		requestDispatcher.forward(request, response);
	}
}
