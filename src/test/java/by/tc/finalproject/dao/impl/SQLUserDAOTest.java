package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLUserDAOTest {
	@Test
	public void testInsertUserX0001() {
		try {
			UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
			State state = new State(85, 97, 85, 98);
			User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);

			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getUserDAO().addUser(user, "Факультет Компьютерных Систем И Сетей");

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.user WHERE passport=?");
			preparedStatement.setString(1, "ab452716");
			ResultSet resultSet = preparedStatement.executeQuery();
			Assert.assertTrue(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistUserX0001() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getUserDAO().isExistUser("ab452716");
			Assert.assertTrue(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEditUserX0001() {
		try {
			UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
			State state = new State(85, 97, 85, 89);
			User editUser = new User("Горегляд", "Алексей", "ab452716", userAccess, state);

			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getUserDAO().editUser("ab452716", "Факультет Компьютерных Систем И Сетей", editUser);

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.user WHERE passport=? and name=?");
			preparedStatement.setString(1, "ab452716");
			preparedStatement.setString(1, "Алексей");
			ResultSet resultSet = preparedStatement.executeQuery();
			Assert.assertTrue(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteUserX0003() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getUserDAO().deleteUser("ab452716");

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.user WHERE passport=?");
			preparedStatement.setString(1, "ab452716");
			ResultSet resultSet = preparedStatement.executeQuery();

			Assert.assertFalse(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistUserX0002() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getUserDAO().isExistUser("ab452716");
			Assert.assertFalse(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
