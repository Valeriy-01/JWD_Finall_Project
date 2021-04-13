package by.tc.applicant.controller.command.impl.transition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.applicant.controller.command.Command;

public class GoToFacultyPage implements Command {
	private static final String PATH_TO_FACULTY_PAGE = "/WEB-INF/jsp/courses.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_FACULTY_PAGE);
		requestDispatcher.forward(request, response);
	}
}
