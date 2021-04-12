package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.tc.finalproject.bean.Committee;
import by.tc.finalproject.dao.CommitteeDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLCommitteeDAO implements CommitteeDAO {

	private static final String SQL_INSERT_COMMITTEE = "INSERT INTO committee (email, password,login) VALUES(?,?,?)";
	private static final String SQL_UPDATE_COMMITTEE = "UPDATE committee SET email=?,password=? WHERE login=?";
	private static final String SQL_DELETE_COMMITTEE = "DELETE FROM committee WHERE login=?";
	private static final String SQL_EXIST_COMMITTEE = "SELECT * FROM committee WHERE email=? and password=?";

	@Override
	public void addCommittee(Committee committee) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		if (!isExistCommittee(committee.getEmail(), committee.getPassword())) {
			try {
				connection = connectionPool.getConnection();
				preparedStatement = connection.prepareStatement(SQL_INSERT_COMMITTEE);
				preparedStatement.setString(1, committee.getEmail());
				preparedStatement.setString(2, committee.getPassword());
				preparedStatement.setString(3, committee.getLogin());
				preparedStatement.executeUpdate();
			} catch (SQLException | ConnectionPoolException e) {
				throw new DAOException("Error while writing committee to table", e);
			} finally {
				if (preparedStatement != null) {
					connectionPool.closePreparedStatement(preparedStatement);
				}
				connectionPool.releaseConnection(connection);
			}
		}

	}

	@Override
	public void deleteCommittee(String login) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_COMMITTEE);
			preparedStatement.setString(1, login);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting committee in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	@Override
	public boolean isExistCommittee(String email, String password) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_EXIST_COMMITTEE);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error check committee in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void editCommittee(String login, Committee committee) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		if (!isExistCommittee(committee.getEmail(), committee.getPassword())) {
			try {
				connection = connectionPool.getConnection();
				preparedStatement = connection.prepareStatement(SQL_UPDATE_COMMITTEE);
				preparedStatement.setString(1, committee.getEmail());
				preparedStatement.setString(2, committee.getPassword());
				preparedStatement.setString(3, login);
				preparedStatement.executeUpdate();
			} catch (SQLException | ConnectionPoolException e) {
				throw new DAOException("Error editing committee in table", e);
			} finally {
				if (preparedStatement != null) {
					connectionPool.closePreparedStatement(preparedStatement);
				}
				connectionPool.releaseConnection(connection);
			}
		}
	}
}
