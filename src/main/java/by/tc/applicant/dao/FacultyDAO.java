package by.tc.applicant.dao;

import java.util.ArrayList;

import by.tc.applicant.bean.Faculty;
import by.tc.applicant.dao.exception.DAOException;

public interface FacultyDAO {
	void addFaculty(Faculty faculty) throws DAOException;

	void deleteFaculty(String facultyTitle) throws DAOException;

	void editFaculty(String facultyTitle, Faculty editFaculty) throws DAOException;

	boolean isExistFaculty(String title) throws DAOException;

	int findFacultyId(String facultyTitle) throws DAOException;

	String getFacultyTitle(int id) throws DAOException;

	Faculty getFaculty(int id) throws DAOException;

	ArrayList<Faculty> getFaculties() throws DAOException;
}
