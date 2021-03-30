package by.tc.finalproject.controller.command.impl.transition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.finalproject.controller.command.Command;

public class GoToFITUPage implements Command {
	private static final String PATH_TO_FITU_PATIENT = "/WEB-INF/jsp/course-single3.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_FITU_PATIENT);
		requestDispatcher.forward(request, response);
	}
}
