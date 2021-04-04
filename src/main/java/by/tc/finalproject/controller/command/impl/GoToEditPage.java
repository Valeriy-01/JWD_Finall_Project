package by.tc.finalproject.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.finalproject.controller.command.Command;

public class GoToEditPage implements Command {
	private static final String PATH_TO_EDIT_PAGE = "/WEB-INF/jsp/edit.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_EDIT_PAGE);
		requestDispatcher.forward(request, response);
	}
}
