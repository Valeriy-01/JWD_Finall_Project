package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import by.tc.finalproject.bean.Faculty;
import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLFacultyDAOTest {
	@Test
	public void testInsertFacultyX0001() {
		try {
			PlanRequirements planRequirements = new PlanRequirements(2, 0);
			SubjectRequirements subjectRequirements = new SubjectRequirements("Математика", "Физика", "Русский язык");
			Faculty faculty = new Faculty("Факультет Компьютерных Систем И Сетей", planRequirements,
					subjectRequirements);

			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getFacultyDAO().addFaculty(faculty);

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
			preparedStatement.setString(1, "Факультет Компьютерных Систем И Сетей");
			ResultSet resultSet = preparedStatement.executeQuery();

			Assert.assertTrue(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExistFacultyX0001() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Компьютерных Систем И Сетей");
			Assert.assertTrue(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEditFacultyX0001() {
		try {
			PlanRequirements planRequirements = new PlanRequirements(2, 0);
			SubjectRequirements subjectRequirements = new SubjectRequirements("Математика", "Физика", "Русский язык");
			Faculty editFaculty = new Faculty("Факультет Компьютерного Проектирования", planRequirements,
					subjectRequirements);

			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getFacultyDAO().editFaculty("Факультет Компьютерных Систем И Сетей",editFaculty);

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
			preparedStatement.setString(1, "Факультет Компьютерного Проектирования");
			ResultSet resultSet = preparedStatement.executeQuery();

			Assert.assertTrue(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsExistFacultyX0002() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Компьютерных Систем И Сетей");
			Assert.assertFalse(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsExistFacultyX0003() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Компьютерного Проектирования");
			Assert.assertTrue(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteFacultyX0003() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			daoProvider.getFacultyDAO().deleteFaculty("Факультет Компьютерного Проектирования");

			Connection connection = ConnectionPool.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
			preparedStatement.setString(1, "Факультет Компьютерного Проектирования");
			ResultSet resultSet = preparedStatement.executeQuery();

			Assert.assertFalse(resultSet.next());
		} catch (SQLException | ConnectionPoolException | DAOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsExistFacultyX0004() {
		try {
			DAOProvider daoProvider = DAOProvider.getInstance();
			boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Компьютерного Проектирования");
			Assert.assertFalse(result);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
