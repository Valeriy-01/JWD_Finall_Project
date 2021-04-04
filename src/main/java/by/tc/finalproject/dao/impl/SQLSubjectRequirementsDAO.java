package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private static final String SQL_SELECT_SUBJECT = "SELECT * FROM committee.subjects_requirements WHERE id=?";

	@Override
	public void addSubjectRequirements(Connection connection, SubjectRequirements subjectRequirements)
			throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERT_SUBJECT);
			preparedStatement.setInt(1, subjectRequirements.getId());
			preparedStatement.setString(2, subjectRequirements.getFirstSubject());
			preparedStatement.setString(3, subjectRequirements.getSecondSubject());
			preparedStatement.setString(4, subjectRequirements.getThirdSubject());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while writing subject requirements in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}

	}

	@Override
	public void deleteSubjectRequirements(Connection connection, int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_DELETE_SUBJECT);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting subject requirements in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public void editSubjectRequirements(Connection connection, String facultyTitle,
			SubjectRequirements subjectsRequirements) throws DAOException {
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_UPDATE_SUBJECT);
			preparedStatement.setString(1, subjectsRequirements.getFirstSubject());
			preparedStatement.setString(2, subjectsRequirements.getSecondSubject());
			preparedStatement.setString(3, subjectsRequirements.getThirdSubject());
			preparedStatement.setInt(4, facultyId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error editing subject requirements in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public SubjectRequirements getSubjectRequirements(int id) throws DAOException {
		SubjectRequirements subjectRequirements = new SubjectRequirements();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_SUBJECT);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				subjectRequirements.setId(id);
				subjectRequirements.setFirstSubject(resultSet.getString(2));
				subjectRequirements.setSecondSubject(resultSet.getString(3));
				subjectRequirements.setThirdSubject(resultSet.getString(4));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get subject requirements from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}
		return subjectRequirements;
	}
}
