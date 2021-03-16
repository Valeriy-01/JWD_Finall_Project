package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.TransferUser;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.UserDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLUserDAO implements UserDAO {

	private static final String SQL_INSERT_USER = "INSERT INTO committee.user (faculty_id,surname,name,passport) VALUES(?,?,?,?)";
	private static final String SQL_SELECT_USER_ID = "SELECT id FROM committee.user WHERE passport=?";
	private static final String SQL_UPDATE_USER = "UPDATE committee.user SET faculty_id=?,surname=?,name=?,passport=? WHERE id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM committee.user WHERE id=?";
	private static final String SQL_EXIST_USER = "SELECT * FROM committee.user WHERE passport=?";
	private static final String SQL_SELECT_USER = "SELECT * FROM committee.user WHERE id=?";
	private static final String SQL_SELECT_ALL_USER = "SELECT * FROM committee.user";

	@Override
	public boolean addUser(User user, UserAccess userAccess, State state, String facultyTitle) throws DAOException {
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);

		if (!isExistUser(user.getPassport())) {
			try (Connection connection = ConnectionPool.getInstance().getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {
				preparedStatement.setInt(1, facultyId);
				preparedStatement.setString(2, user.getSurname());
				preparedStatement.setString(3, user.getName());
				preparedStatement.setString(4, user.getPassport());
				preparedStatement.execute();

				userAccess.setId(findUserId(user.getPassport()));
				DAOProvider.getInstance().getUserAccessDAO().addUserAccess(userAccess);

				DAOProvider.getInstance().getStateDAO().updateStatement(state, findUserId(user.getPassport()));
				return DAOProvider.getInstance().getStateDAO().addUserInState(state);
			} catch (SQLException | ConnectionPoolException e) {
				throw new DAOException("Error while writing user to table", e);
			}
		}
		return false;
	}

	@Override
	public boolean isExistUser(String passport) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_USER)) {
			preparedStatement.setString(1, passport);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error check user in table", e);
		}
	}

	@Override
	public boolean deleteUser(String passport) throws DAOException {
		int userId = findUserId(passport);

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER)) {
			preparedStatement.setInt(1, userId);
			preparedStatement.execute();

			DAOProvider.getInstance().getUserAccessDAO().deleteUserAccess(userId);
			DAOProvider.getInstance().getStateDAO().deleteState(userId);
			return DAOProvider.getInstance().getAdmissionResultDAO().deleteAdmissionResult(userId);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting user in table", e);
		}

	}

	@Override
	public int findUserId(String passport) throws DAOException {
		int id = 0;

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ID)) {
			preparedStatement.setString(1, passport);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user in table", e);
		}

		return id;
	}

	@Override
	public boolean editUser(String passport, String userFaculty, User editUser, State editState,
			UserAccess editUserAccess) throws DAOException {
		int userId = findUserId(passport);
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(userFaculty);

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER)) {
			preparedStatement.setInt(1, facultyId);
			preparedStatement.setString(2, editUser.getSurname());
			preparedStatement.setString(3, editUser.getName());
			preparedStatement.setString(4, editUser.getPassport());
			preparedStatement.setInt(5, userId);

			preparedStatement.execute();

			DAOProvider.getInstance().getStateDAO().editStatement(userId, editState);
			return DAOProvider.getInstance().getUserAccessDAO().editUserAccess(userId, editUserAccess);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing user in table", e);
		}
	}

	@Override
	public User getUser(int id) throws DAOException {
		User user = new User();

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setId(id);
				user.setFacultyId(resultSet.getInt(2));
				user.setSurname(resultSet.getString(3));
				user.setName(resultSet.getString(4));
				user.setPassport(resultSet.getString(5));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user in table", e);
		}

		return user;
	}

	@Override
	public ArrayList<TransferUser> getUsers() throws DAOException {
		ArrayList<TransferUser> transferUsers = new ArrayList<>();
		TransferUser transferUser;

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USER)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				transferUser = new TransferUser();
				transferUser.setId(id);
				transferUser.setFacultyId(resultSet.getInt(2));
				transferUser.setSurname(resultSet.getString(3));
				transferUser.setName(resultSet.getString(4));
				DAOProvider.getInstance().getUserAccessDAO().getUserAccess(transferUser, id);
				DAOProvider.getInstance().getStateDAO().getState(transferUser, id);
				transferUsers.add(transferUser);
			}
			return transferUsers;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of get users in table", e);
		}
	}

}
