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

	/*
	 * Начальные условия : база данных не содержит заданный факультет
	 */

	@Test
	public void testInsertFacultyX0001() throws DAOException, ConnectionPoolException, SQLException {
		PlanRequirements planRequirements = new PlanRequirements(2, 0);
		SubjectRequirements subjectRequirements = new SubjectRequirements("Математика", "Физика", "Русский язык");
		Faculty faculty = new Faculty("Факультет Компьютерных Систем И Сетей", planRequirements, subjectRequirements);

		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getFacultyDAO().addFaculty(faculty);

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
		preparedStatement.setString(1, "Факультет Компьютерных Систем И Сетей");
		ResultSet resultSet = preparedStatement.executeQuery();

		Assert.assertTrue(resultSet.next());

	}

	/*
	 * Начальные условия : база данных содержит заданный факультет
	 */

	@Test
	public void testIsExistFacultyX0001() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Сетей");
		Assert.assertTrue(result);
	}

	/*
	 * Начальные условия : база данных содержит заданный факультет
	 */

	@Test
	public void testEditFacultyX0001() throws DAOException, SQLException, ConnectionPoolException {

		PlanRequirements planRequirements = new PlanRequirements(2, 0);
		SubjectRequirements subjectRequirements = new SubjectRequirements("Математика", "Физика", "Русский язык");
		Faculty editFaculty = new Faculty("Факультет Проектирования", planRequirements, subjectRequirements);
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getFacultyDAO().editFaculty("Факультет Для редактирования", editFaculty);
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
		preparedStatement.setString(1, "Факультет Проектирования");
		ResultSet resultSet = preparedStatement.executeQuery();

		Assert.assertTrue(resultSet.next());

	}

	/*
	 * Начальные условия : база данных не содержит заданный факультет
	 */

	@Test
	public void testIsExistFacultyX0002() throws DAOException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		boolean result = daoProvider.getFacultyDAO().isExistFaculty("Факультет Систем");
		Assert.assertFalse(result);
	}

	/*
	 * Начальные условия : база данных содержит заданный факультет и факультет не
	 * имеет абитуриентов
	 */

	@Test
	public void testDeleteFacultyX0001() throws DAOException, ConnectionPoolException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getFacultyDAO().deleteFaculty("Факультет Для удаления");

		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT id FROM committee.faculty WHERE title=?");
		preparedStatement.setString(1, "Факультет Для удаления");
		ResultSet resultSet = preparedStatement.executeQuery();

		Assert.assertFalse(resultSet.next());
	}

}
