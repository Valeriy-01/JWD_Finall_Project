package by.tc.applicant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import by.tc.applicant.bean.Committee;
import by.tc.applicant.dao.DAOProvider;
import by.tc.applicant.dao.exception.DAOException;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.dao.pool.exception.ConnectionPoolException;

public class SQLCommitteeDAOTest {

	/*
	 * Начальные условия : база данных не должна содержать заданного администратора
	 */

	@Test
	public void testInsertCommitteeX0001() throws DAOException, ConnectionPoolException, SQLException {
		Committee committee = new Committee("insert@mail.ru", "12345678", "insert");
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().addCommittee(committee);
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM committee WHERE email='insert@mail.ru' and password='12345678'");
		Assert.assertTrue(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0001() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertTrue(daoProvider.getCommitteeDAO().isExistCommittee("exist@mail.ru", "12345678"));
	}

	/*
	 * Начальные условия : база данных должна содержать заданного администратора
	 */

	@Test
	public void testEditCommitteeX0001() throws DAOException, SQLException, ConnectionPoolException {
		Committee editCommittee = new Committee("editation@mail.ru", "123456789", "edit");
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().editCommittee("edit", editCommittee);

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM committee WHERE email='editation@mail.ru'");
		Assert.assertTrue(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных не содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0002() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("no_exist@mail.ru", "12345678"));
	}

	/*
	 * Начальные условия : база данных содержит заданного администратора
	 */

	@Test
	public void testDeleteCommitteeX0001() throws DAOException, ConnectionPoolException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().deleteCommittee("delete");
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM committee WHERE email='delete@mail.ru' and password='12345678'");
		Assert.assertFalse(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных не содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0004() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("committee@mail.ru", ""));
	}

}
