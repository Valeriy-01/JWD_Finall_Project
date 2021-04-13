package by.tc.applicant.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.applicant.controller.command.Command;

public class GoToMainPage implements Command {
	private static final String PATH_TO_MAIN_PATIENT = "/WEB-INF/jsp/main.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_MAIN_PATIENT);
		requestDispatcher.forward(request, response);
	}
}
