package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.SubjectRequirementsDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLSubjectRequirementsDAO implements SubjectRequirementsDAO {

	private static final String SQL_INSERT_SUBJECT = "INSERT INTO committee.subjects_requirements(id,subject_1, subject_2,subject_3) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE_SUBJECT = "UPDATE committee.subjects_requirements SET subject_1=?, subject_2=?,subject_3=? WHERE id=?";
	private static final String SQL_DELETE_SUBJECT = "DELETE FROM committee.subjects_requirements WHERE id=?";

	@Override
	public boolean addSubjectRequirements(SubjectRequirements subjectRequirements) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_SUBJECT)) {
			preparedStatement.setInt(1, subjectRequirements.getId());
			preparedStatement.setString(2, subjectRequirements.getFirstSubject());
			preparedStatement.setString(3, subjectRequirements.getSecondSubject());
			preparedStatement.setString(4, subjectRequirements.getThirdSubject());

			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing subject requirements to table", e);
		}

	}

	@Override
	public boolean deleteSubjectRequirements(int id) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_SUBJECT)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting subject requirements in table", e);
		}
	}

	@Override
	public boolean editSubjectRequirements(String facultyTitle, SubjectRequirements subjectsRequirements)
			throws DAOException {
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SUBJECT)) {
			preparedStatement.setString(1, subjectsRequirements.getFirstSubject());
			preparedStatement.setString(2, subjectsRequirements.getSecondSubject());
			preparedStatement.setString(3, subjectsRequirements.getThirdSubject());
			preparedStatement.setInt(4, facultyId);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing subject requirements in table", e);
		}
	}
}
