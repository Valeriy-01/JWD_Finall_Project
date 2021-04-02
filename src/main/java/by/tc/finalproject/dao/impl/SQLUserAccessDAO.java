package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.UserAccessDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLUserAccessDAO implements UserAccessDAO {

	private static final String SQL_INSERT_USER_ACCESS = "INSERT INTO committee.user_access(id, email,password) VALUES(?,?,?)";
	private static final String SQL_UPDATE_USER_ACCESS = "UPDATE committee.user_access SET email=?,password=? WHERE id=?";
	private static final String SQL_DELETE_USER_ACCESS = "DELETE FROM committee.user_access WHERE id=?";
	private static final String SQL_EXIST_LOGIN_USER_ACCESS = "SELECT * FROM committee.user_access WHERE email=? and password=?";
	private static final String SQL_SELECT_USER_ACCESS_ID = "SELECT id FROM committee.user_access WHERE email=? and password=?";
	private static final String SQL_SELECT_USER_ACCESS = "SELECT * FROM committee.user_access WHERE id=?";

	@Override
	public void addUserAccess(Connection connection, UserAccess userAccess) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERT_USER_ACCESS);
			preparedStatement.setInt(1, userAccess.getId());
			preparedStatement.setString(2, userAccess.getEmail());
			preparedStatement.setString(3, userAccess.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while writing user access to table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
		}

	}

	@Override
	public void deleteUserAccess(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_USER_ACCESS);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting user access in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	public boolean isExistLoginUserAccess(String email, String password) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_EXIST_LOGIN_USER_ACCESS);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error find user access in table");
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void editUserAccess(Connection connection, int userId, UserAccess editUserAccess) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_ACCESS);
			preparedStatement.setString(1, editUserAccess.getEmail());
			preparedStatement.setString(2, editUserAccess.getPassword());
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error editing user access in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
		}
	}

	@Override
	public int findUserAccessId(String email, String password) throws DAOException {
		int id = -1;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ACCESS_ID);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get user access id from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

		return id;
	}

	@Override
	public UserAccess getUserAccess(int id) throws DAOException {
		UserAccess userAccess = new UserAccess();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ACCESS);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userAccess.setId(id);
				userAccess.setEmail(resultSet.getString(2));
				userAccess.setPassword(resultSet.getString(3));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get user access from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

		return userAccess;
	}

}