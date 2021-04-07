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
import by.tc.finalproject.service.CommitteeService;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class SQLCommitteeDAOTest {
	@Test
	public void testInsertCommitteeX0001() {
		try {
			Committee committee = new Committee("committee_01@mail.ru", "ddsdfew32fv", "admin_09jfe");
			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getCommitteeDAO().addCommittee(committee);
			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM committee.committee WHERE email='committee_01@mail.ru' and password='ddsdfew32fv'");
			Assert.assertTrue(preparedStatement.executeQuery().next());
		} catch (DAOException | ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistCommitteeX0001() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			Assert.assertTrue(daoProvider.getCommitteeDAO().isExistCommittee("committee_01@mail.ru", "ddsdfew32fv"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEditCommitteeX0001() {
		try {
			Committee editCommittee = new Committee("committee@mail.ru", "ddsdfew32fv", "admin_09jfe");
			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getCommitteeDAO().editCommittee("admin_09jfe", editCommittee);

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM committee.committee WHERE email='committee@mail.ru' and password='ddsdfew32fv'");
			Assert.assertTrue(preparedStatement.executeQuery().next());

		} catch (DAOException | ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistCommitteeX0002() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("committee_01@mail.ru", "ddsdfew32fv"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistCommitteeX0003() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			Assert.assertTrue(daoProvider.getCommitteeDAO().isExistCommittee("committee@mail.ru", "ddsdfew32fv"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewCommitteeX0001() {
		try {
			CommitteeService committeeService = ServiceProvider.getInstance().getCommitteeService();
			boolean result = committeeService.authorization("committee@mail.ru", "ddsdfew32fv");
			Assert.assertTrue(result);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testViewCommitteeX0002() {
		try {
			CommitteeService committeeService = ServiceProvider.getInstance().getCommitteeService();
			boolean result = committeeService.authorization("committee@mail.ru", "");
			Assert.assertFalse(result);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDeleteCommitteeX0001() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getCommitteeDAO().deleteCommittee("admin_09jfe");

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM committee.committee WHERE email='committee@mail.ru' and password='ddsdfew32fv'");
			Assert.assertFalse(preparedStatement.executeQuery().next());
		} catch (DAOException | ConnectionPoolException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testIsExistCommitteeX0004() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			Assert.assertFalse(daoProvider.getCommitteeDAO().isExistCommittee("committee@mail.ru", "ddsdfew32fv"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
