package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import by.tc.finalproject.bean.Committee;

import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLCommitteeDAOTest {

	/*
	 * Начальные условия : база данных не должна содержать заданного администратора
	 */

	@Test
	public void testInsertCommitteeX0001() throws DAOException, ConnectionPoolException, SQLException {
		Committee committee = new Committee("committee_01@mail.ru", "ddsdfew32fv", "admin_09jfe");
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().addCommittee(committee);
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM committee.committee WHERE email='committee_01@mail.ru' and password='ddsdfew32fv'");
		Assert.assertTrue(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0001() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertTrue(daoProvider.getCommitteeDAO().isExistCommittee("c@mail.ru", "12345678"));
	}

	/*
	 * Начальные условия : база данных должна содержать заданного администратора
	 */

	@Test
	public void testEditCommitteeX0001() throws DAOException, SQLException, ConnectionPoolException {
		Committee editCommittee = new Committee("comm@mail.ru", "sdv32dwfef2", "administrator");
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().editCommittee("admin_01", editCommittee);

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM committee.committee WHERE login='administrator'");
		Assert.assertTrue(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных не содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0002() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("co@mail.ru", "ddsdfew32fv"));
	}

	/*
	 * Начальные условия : база данных содержит заданного администратора
	 */

	@Test
	public void testDeleteCommitteeX0001() throws DAOException, ConnectionPoolException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getCommitteeDAO().deleteCommittee("admin_del");
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM committee.committee WHERE email='committee@mail.ru' and password='ddsdfew32fv'");
		Assert.assertFalse(preparedStatement.executeQuery().next());
	}

	/*
	 * Начальные условия : база данных не содержит заданного администратора
	 */

	@Test
	public void testIsExistCommitteeX0004() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("committee@mail.ru", "ddsdfew32fv"));
	}

}
