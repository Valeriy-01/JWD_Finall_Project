package by.tc.finalproject.controller.command.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.finalproject.controller.command.Command;

import java.io.IOException;

public class GoToPersonPage implements Command{
	private static final String PATH_TO_PERSON_PAGE = "/WEB-INF/jsp/personal-account.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_PERSON_PAGE);
		requestDispatcher.forward(request, response);
	}

}
