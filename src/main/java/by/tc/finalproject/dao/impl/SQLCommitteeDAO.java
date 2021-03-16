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

	private static final String SQL_INSERT_COMMITTEE = "INSERT INTO committee.committee (email, password,login) VALUES(?,?,?)";
	private static final String SQL_UPDATE_COMMITTEE = "UPDATE committee.committee SET email=?,password=?,login=? WHERE login=?";
	private static final String SQL_DELETE_COMMITTEE = "DELETE FROM committee.committee WHERE login=?";
	private static final String SQL_EXIST_COMMITTEE = "SELECT * FROM committee.committee WHERE email=? and password=?";

	@Override
	public boolean addCommittee(Committee committee) throws DAOException {
		if (!isExistCommittee(committee.getEmail(), committee.getPassword())) {
			try (Connection connection = ConnectionPool.getInstance().getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_COMMITTEE)) {
				preparedStatement.setString(1, committee.getEmail());
				preparedStatement.setString(2, committee.getPassword());
				preparedStatement.setString(3, committee.getLogin());
				return preparedStatement.execute();
			} catch (SQLException | ConnectionPoolException e) {
				throw new DAOException("Error while writing committee to table", e);
			}
		}
		return false;

	}

	@Override
	public boolean deleteCommittee(String login) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_COMMITTEE)) {
			preparedStatement.setString(1, login);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting committee in table", e);
		}

	}

	@Override
	public boolean isExistCommittee(String email, String password) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_COMMITTEE)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error check committee in table", e);
		}
	}

	@Override
	public boolean editCommittee(String login, Committee committee) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_COMMITTEE)) {
			preparedStatement.setString(1, committee.getEmail());
			preparedStatement.setString(2, committee.getPassword());
			preparedStatement.setString(3, committee.getLogin());
			preparedStatement.setString(4, login);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing committee in table", e);
		}
	}
}
