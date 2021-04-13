package by.tc.applicant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import by.tc.applicant.bean.State;
import by.tc.applicant.bean.User;
import by.tc.applicant.bean.UserAccess;
import by.tc.applicant.dao.DAOProvider;
import by.tc.applicant.dao.exception.DAOException;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.dao.pool.exception.ConnectionPoolException;

public class SQLUserDAOTest {

	/*
	 * Начальные условия : база данных содержит заданный факультет и не
	 * содержит заданного пользователя
	 */

	@Test
	public void testInsertUserX0001() throws DAOException, ConnectionPoolException, SQLException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("ВСТАВКА", "Валерий", "11111111111", userAccess, state);

		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getUserDAO().addUser(user, "Существует ли");

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM user WHERE passport=?");
		preparedStatement.setString(1, "11111111111");
		ResultSet resultSet = preparedStatement.executeQuery();
		Assert.assertTrue(resultSet.next());
	}

	/*
	 * Начальные условия : база данных содержит заданного пользователя
	 */

	@Test
	public void testIsExistUserX0001() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		boolean result = daoProvider.getUserDAO().isExistUser("testIsExist");
		Assert.assertTrue(result);
	}

	/*
	 * Начальные условия : база данных содержит заданный факультет и
	 * содержит заданного пользователя
	 */

	@Test
	public void testEditUserX0001() throws DAOException, ConnectionPoolException, SQLException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 89);
		User editUser = new User("Отредактирован", "Алексей", "ab452716", userAccess, state);

		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getUserDAO().editUser("ab452716", "Существует ли", editUser);

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM user WHERE passport=?");
		preparedStatement.setString(1, "ab452716");
		ResultSet resultSet = preparedStatement.executeQuery();
		Assert.assertTrue(resultSet.next());
	}

	/*
	 * Начальные условия : база данных содержит заданного пользователя
	 */

	@Test
	public void testDeleteUserX0003() throws DAOException, ConnectionPoolException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getUserDAO().deleteUser("udalenie");

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM user WHERE passport=?");
		preparedStatement.setString(1, "udalenie");
		ResultSet resultSet = preparedStatement.executeQuery();

		Assert.assertFalse(resultSet.next());
	}

	/*
	 * Начальные условия : база данных не содержит заданного пользователя
	 */

	@Test
	public void testIsExistUserX0002() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		boolean result = daoProvider.getUserDAO().isExistUser("example");
		Assert.assertFalse(result);
	}
}
