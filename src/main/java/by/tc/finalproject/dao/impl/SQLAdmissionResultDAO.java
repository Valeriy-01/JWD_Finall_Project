package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.dao.AdmissionResultDAO;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLAdmissionResultDAO implements AdmissionResultDAO {
	private static final String SQL_INSERT_ADMISSION = "INSERT INTO admission_result(student_id, result) VALUES(?,?)";
	private static final String SQL_UPDATE_ADMISSION = "UPDATE admission_result SET result=? WHERE student_id=?";
	private static final String SQL_DELETE_ADMISSION = "DELETE FROM admission_result WHERE student_id=?";
	private static final String SQL_SELECT_ADMISSION = "SELECT * FROM admission_result WHERE student_id=?";

	@Override
	public void addAdmissionResult(Connection connection, int id, AdmissionResult admissionResult) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERT_ADMISSION);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, admissionResult.getAdmissionResult());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error add admission result in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public void deleteAdmissionResult(Connection connection, int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_ADMISSION);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting admission result in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}

	}

	@Override
	public void editAdmissionResult(String passport, AdmissionResult admissionResult) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_UPDATE_ADMISSION);
			int userId = DAOProvider.getInstance().getUserDAO().findUserId(passport);
			preparedStatement.setInt(1, admissionResult.getAdmissionResult());
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing admission result in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}
	}

	@Override
	public AdmissionResult getAdmissionResult(String passport) throws DAOException {
		AdmissionResult admissionResult = new AdmissionResult();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_ADMISSION);
			int id = DAOProvider.getInstance().getUserDAO().findUserId(passport);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				admissionResult.setStudentId(id);
				admissionResult.setAdmissionResult(resultSet.getInt(2));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

		return admissionResult;
	}

	@Override
	public boolean isCreateEnrolleList() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_ADMISSION);
			int id = DAOProvider.getInstance().getUserDAO().getNextMaxUserID() - 1;
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt(2) != -1) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}
		return false;

	}

}
