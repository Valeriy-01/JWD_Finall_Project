package by.tc.applicant.controller.command.impl.transition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.applicant.controller.command.Command;

public class GoToFRFPage implements Command {
	private static final String PATH_TO_FR_PAGE = "/WEB-INF/jsp/course-single4.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_FR_PAGE);
		requestDispatcher.forward(request, response);
	}
}
