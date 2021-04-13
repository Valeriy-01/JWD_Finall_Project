package by.tc.applicant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.tc.applicant.bean.AdmissionResult;
import by.tc.applicant.bean.State;
import by.tc.applicant.bean.User;
import by.tc.applicant.bean.UserAccess;
import by.tc.applicant.dao.DAOProvider;
import by.tc.applicant.dao.UserDAO;
import by.tc.applicant.dao.exception.DAOException;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.dao.pool.exception.ConnectionPoolException;

public class SQLUserDAO implements UserDAO {

	private static final String SQL_INSERT_USER = "INSERT INTO user (faculty_id,surname,name,passport) VALUES(?,?,?,?)";
	private static final String SQL_SELECT_USER_ID = "SELECT id FROM user WHERE passport=?";
	private static final String SQL_UPDATE_USER = "UPDATE user SET faculty_id=?,surname=?,name=?,passport=? WHERE id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";
	private static final String SQL_EXIST_USER = "SELECT * FROM user WHERE passport=?";
	private static final String SQL_SELECT_USER = "SELECT * FROM user WHERE id=?";
	private static final String SQL_SELECT_ALL_USER = "SELECT * FROM user";
	private static final String SQL_SELECT_ALL_USER_WITH_ID = "SELECT * FROM user WHERE faculty_id=?";
	private static final String SQL_SELECT_MAX_USER_ID = "SELECT MAX(id) FROM user";
	private static final int UNKNOWN_CONDITION = -1;

	@Override
	public void addUser(User user, String facultyTitle) throws DAOException {
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);
		if (!isExistUser(user.getPassport())) {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = connectionPool.getConnection();
				connection.setAutoCommit(false);
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
				preparedStatement.setInt(1, facultyId);
				preparedStatement.setString(2, user.getSurname());
				preparedStatement.setString(3, user.getName());
				preparedStatement.setString(4, user.getPassport());
				preparedStatement.execute();
				addAllData(user, connection);
				connection.commit();
			} catch (SQLException | ConnectionPoolException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					throw new DAOException("Error while roolback user add", e);
				}
				throw new DAOException("Error while writing user to table", e);
			} finally {
				if (preparedStatement != null) {
					connectionPool.closePreparedStatement(preparedStatement);
				}
				try {
					connection.setAutoCommit(true);
					connectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					throw new DAOException("Error while setting commit user", e);
				}
			}

		}
	}

	private void addAllData(User user, Connection connection) throws DAOException, SQLException {
		DAOProvider provider = DAOProvider.getInstance();
		int id = findUserId(user.getPassport());
		user.getUserAccess().setId(id);
		user.getState().setStudentId(id);
		provider.getUserAccessDAO().addUserAccess(connection, user.getUserAccess());
		provider.getAdmissionResultDAO().addAdmissionResult(connection, id, new AdmissionResult(UNKNOWN_CONDITION));
		provider.getStateDAO().addUserInState(connection, user.getState());
	}

	@Override
	public boolean isExistUser(String passport) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_EXIST_USER);
			preparedStatement.setString(1, passport);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error check user in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	public int getNextMaxUserID() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = -1;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_MAX_USER_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			return ++id;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get Max ID from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	@Override
	public void deleteUser(String passport) throws DAOException {
		int userId = findUserId(passport);
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting user in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			try {
				connection.setAutoCommit(true);
				connectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				throw new DAOException("Error setting commit delete user", e);

			}
		}

	}

	@Override
	public int findUserId(String passport) throws DAOException {
		int id = 0;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ID);
			preparedStatement.setString(1, passport);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get user id from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

		return id;
	}

	@Override
	public void editUser(String passport, String userFaculty, User editUser) throws DAOException {
		DAOProvider provider = DAOProvider.getInstance();
		int facultyId = provider.getFacultyDAO().findFacultyId(userFaculty);
		int userId = findUserId(editUser.getPassport());
		editUser.setFacultyId(facultyId);
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
			preparedStatement.setInt(1, facultyId);
			preparedStatement.setString(2, editUser.getSurname());
			preparedStatement.setString(3, editUser.getName());
			preparedStatement.setString(4, editUser.getPassport());
			preparedStatement.setInt(5, userId);
			preparedStatement.execute();
			editAllData(editUser, connection, userId);
			connection.commit();
		} catch (SQLException | ConnectionPoolException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new DAOException("Error while rollback edit user ", e);
			}
			throw new DAOException("Error editing user in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			try {
				connection.setAutoCommit(true);
				connectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				throw new DAOException("Error while setting commit edit user", e);
			}
		}

	}

	private void editAllData(User editUser, Connection connection, int userId) throws DAOException, SQLException {
		DAOProvider provider = DAOProvider.getInstance();
		provider.getStateDAO().editStatement(connection, userId, editUser.getState());
		provider.getUserAccessDAO().editUserAccess(connection, userId, editUser.getUserAccess());
	}

	@Override
	public User getUser(int id) throws DAOException {
		DAOProvider provider = DAOProvider.getInstance();
		User user = new User();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setId(id);
				user.setFacultyId(resultSet.getInt(2));
				user.setSurname(resultSet.getString(3));
				user.setName(resultSet.getString(4));
				user.setPassport(resultSet.getString(5));
			}
			user.setFacultyTitle(provider.getFacultyDAO().getFacultyTitle(user.getFacultyId()));
			UserAccess userAccess = provider.getUserAccessDAO().getUserAccess(id);
			State state = provider.getStateDAO().getState(id);
			user.setUserAccess(userAccess);
			user.setState(state);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get user from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

		return user;
	}

	@Override
	public ArrayList<User> getUsers() throws DAOException {
		ArrayList<User> users = new ArrayList<>();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				User user = getUser(id);
				users.add(user);
			}
			return users;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get users from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	@Override
	public ArrayList<User> getUsers(int facultyId) throws DAOException {
		ArrayList<User> users = new ArrayList<>();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USER_WITH_ID);
			preparedStatement.setInt(1, facultyId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				User user = getUser(id);
				users.add(user);
			}
			return users;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get users with id from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

	}

}
