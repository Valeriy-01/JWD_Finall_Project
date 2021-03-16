package by.tc.finalproject.dao;

import java.sql.Connection;

import by.tc.finalproject.bean.Faculty;
import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface FacultyDAO {
	boolean addFaculty(Faculty faculty, SubjectRequirements subjectsRequirements, PlanRequirements planRequirements)
			throws DAOException;

	boolean deleteFaculty(String facultyTitle) throws DAOException;

	boolean editFaculty(String facultyTitle, Faculty editFaculty) throws DAOException;

	boolean isExistFaculty(String title, Connection connection) throws DAOException;

	int findFacultyId(String facultyTitle) throws DAOException;

	String getFacultyTitle(int id) throws DAOException;
}
