package by.tc.finalproject.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface SubjectRequirementsDAO {
	void addSubjectRequirements(Connection connection, SubjectRequirements subjectRequirements) throws SQLException;

	void deleteSubjectRequirements(Connection connection,int id) throws DAOException;

	void editSubjectRequirements(Connection connection, String facultyTitle, SubjectRequirements subjectsRequirements)
			throws SQLException, DAOException;

	SubjectRequirements getSubjectRequirements(int id) throws DAOException;
}
