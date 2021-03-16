package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.Faculty;
import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.FacultyDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;
public class SQLFacultyDAO implements FacultyDAO {

	private static final String SQL_INSERT_FACULTY = "INSERT INTO committee.faculty(title) VALUES(?)";
	private static final String SQL_SELECT_FACULTY = "SELECT id FROM committee.faculty WHERE title=?";
	private static final String SQL_UPDATE_FACULTY = "UPDATE committee.faculty SET title=? WHERE id=?";
	private static final String SQL_DELETE_FACULTY = "DELETE FROM committee.faculty WHERE id=?";
	private static final String SQL_EXIST_FACULTY = "SELECT * FROM committee.faculty WHERE title=?";
	private static final String SQL_SELECT_FACULTY_TITLE = "SELECT title FROM committee.faculty WHERE id=?";

	@Override
	public boolean addFaculty(Faculty faculty, SubjectRequirements subjectsRequirements,
			PlanRequirements planRequirements) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_FACULTY)) {
			if (!isExistFaculty(faculty.getTitle(), connection)) {
				preparedStatement.setString(1, faculty.getTitle());
				preparedStatement.execute();

				int facultyId = findFacultyId(faculty.getTitle());
				planRequirements.setId(facultyId);
				subjectsRequirements.setId(facultyId);

				DAOProvider.getInstance().getPlanRequirementsDAO().addPlanRequirements(planRequirements);
				return DAOProvider.getInstance().getSubjectRequirementsDAO().addSubjectRequirements(subjectsRequirements);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing faculty to table", e);
		}
		return false;
	}

	@Override
	public boolean isExistFaculty(String title, Connection connection) throws DAOException {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_FACULTY)) {
			preparedStatement.setString(1, title);
			return preparedStatement.executeQuery().next();
		} catch (SQLException e) {
			throw new DAOException("Error check faculty in table", e);
		}
	}

	@Override
	public boolean deleteFaculty(String facultyTitle) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_FACULTY)) {
			int facultyId = findFacultyId(facultyTitle);
			preparedStatement.setInt(1, facultyId);
			preparedStatement.execute();
			DAOProvider.getInstance().getPlanRequirementsDAO().deletePlanRequirements(facultyId);
			DAOProvider.getInstance().getSubjectRequirementsDAO().deleteSubjectRequirements(facultyId);
			return true;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting faculty in table", e);
		}

	}

	@Override
	public boolean editFaculty(String facultyTitle, Faculty editFaculty) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_FACULTY)) {
			int facultyId = findFacultyId(facultyTitle);
			preparedStatement.setString(1, editFaculty.getTitle());
			preparedStatement.setInt(2, facultyId);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing faculty in table", e);
		}
	}

	@Override
	public int findFacultyId(String facultyTitle) throws DAOException {
		int id = 0;
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FACULTY)) {
			preparedStatement.setString(1, facultyTitle);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding faculty in table", e);
		}

		return id;
	}

	@Override
	public String getFacultyTitle(int id) throws DAOException {
		String title = "";
		try (Connection connection = ConnectionPool.getInstance().getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_FACULTY_TITLE)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				title = resultSet.getString(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding user in table", e);
		}

		return title;
	}
}
