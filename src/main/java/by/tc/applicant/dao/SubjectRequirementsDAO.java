package by.tc.applicant.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.applicant.bean.SubjectRequirements;
import by.tc.applicant.dao.exception.DAOException;

public interface SubjectRequirementsDAO {
	void addSubjectRequirements(Connection connection, SubjectRequirements subjectRequirements) throws SQLException;

	void deleteSubjectRequirements(Connection connection,int id) throws DAOException;

	void editSubjectRequirements(Connection connection, String facultyTitle, SubjectRequirements subjectsRequirements)
			throws SQLException, DAOException;

	SubjectRequirements getSubjectRequirements(int id) throws DAOException;
}
