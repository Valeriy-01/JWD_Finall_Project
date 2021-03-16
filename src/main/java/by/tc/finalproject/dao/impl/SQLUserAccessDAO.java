package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.TransferUser;
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
	public boolean addUserAccess(UserAccess userAccess) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER_ACCESS)) {
			preparedStatement.setInt(1, userAccess.getId());
			preparedStatement.setString(2, userAccess.getEmail());
			preparedStatement.setString(3, userAccess.getPassword());

			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing user access to table", e);
		}

	}

	@Override
	public boolean deleteUserAccess(int id) throws DAOException {

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER_ACCESS)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting user access in table", e);
		}

	}

	public boolean isExistLoginUserAccess(String email, String password) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_LOGIN_USER_ACCESS)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing plan requirements to table");
		}
	}

	@Override
	public boolean editUserAccess(int userId, UserAccess editUserAccess) throws DAOException {

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_ACCESS)) {
			preparedStatement.setString(1, editUserAccess.getEmail());
			preparedStatement.setString(2, editUserAccess.getPassword());
			preparedStatement.setInt(3, userId);

			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing user access in table", e);
		}
	}

	@Override
	public int findUserAccessId(String email, String password) throws DAOException {
		int id = 0;

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ACCESS_ID)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user access in table", e);
		}

		return id;
	}

	@Override
	public UserAccess getUserAccess(int id) throws DAOException {
		UserAccess userAccess = new UserAccess();

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ACCESS)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userAccess.setId(id);
				userAccess.setEmail(resultSet.getString(2));
				userAccess.setPassword(resultSet.getString(3));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user access in table", e);
		}

		return userAccess;
	}

	@Override
	public void getUserAccess(TransferUser transferUser, int id) throws DAOException {

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ACCESS)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				transferUser.setEmail(resultSet.getString(2));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of get users access in table", e);
		}

	}

}
