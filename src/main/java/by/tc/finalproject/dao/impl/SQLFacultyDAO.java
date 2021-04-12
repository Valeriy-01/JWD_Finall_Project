package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.tc.finalproject.bean.Faculty;
import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.FacultyDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLFacultyDAO implements FacultyDAO {

	private static final String SQL_INSERT_FACULTY = "INSERT INTO faculty(title) VALUES(?)";
	private static final String SQL_SELECT_FACULTY_ID = "SELECT id FROM faculty WHERE title=?";
	private static final String SQL_UPDATE_FACULTY = "UPDATE faculty SET title=? WHERE id=?";
	private static final String SQL_DELETE_FACULTY = "DELETE FROM faculty WHERE id=?";
	private static final String SQL_EXIST_FACULTY = "SELECT * FROM faculty WHERE title=?";
	private static final String SQL_SELECT_FACULTY_TITLE = "SELECT title FROM faculty WHERE id=?";
	private static final String SQL_SELECT_FACULTY = "SELECT * FROM faculty WHERE id=?";
	private static final String SQL_SELECT_ALL_FACULTY = "SELECT * FROM faculty";

	@Override
	public void addFaculty(Faculty faculty) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		if (!isExistFaculty(faculty.getTitle())) {
			try {
				connection = connectionPool.getConnection();
				connection.setAutoCommit(false);
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				preparedStatement = connection.prepareStatement(SQL_INSERT_FACULTY);
				if (!isExistFaculty(faculty.getTitle())) {
					preparedStatement.setString(1, faculty.getTitle());
					preparedStatement.executeUpdate();
					addAllData(faculty, connection);
					connection.commit();
				}
			} catch (SQLException | ConnectionPoolException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					throw new DAOException("Error while rollback add faculty", e);
				}
				throw new DAOException("Error while writing faculty to table", e);
			} finally {
				if (preparedStatement != null) {
					connectionPool.closePreparedStatement(preparedStatement);
				}
				try {
					connection.setAutoCommit(true);
					connectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					throw new DAOException("Error while commit new faculty in table", e);
				}
			}
		}
	}

	private void addAllData(Faculty faculty, Connection connection) throws DAOException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		int facultyId = findFacultyId(faculty.getTitle());
		faculty.getPlanRequirements().setId(facultyId);
		faculty.getSubjectRequirements().setId(facultyId);
		daoProvider.getPlanRequirementsDAO().addPlanRequirements(connection, faculty.getPlanRequirements());
		daoProvider.getSubjectRequirementsDAO().addSubjectRequirements(connection, faculty.getSubjectRequirements());
	}

	@Override
	public boolean isExistFaculty(String title) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_EXIST_FACULTY);
			preparedStatement.setString(1, title);
			return preparedStatement.executeQuery().next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error check faculty in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}
	}

	@Override
	public void deleteFaculty(String facultyTitle) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			int facultyId = findFacultyId(facultyTitle);
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_FACULTY);
			preparedStatement.setInt(1, facultyId);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting faculty in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			try {
				connection.setAutoCommit(true);
				connectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				throw new DAOException("Error while commit deleting faculty", e);
			}
		}

	}

	@Override
	public void editFaculty(String facultyTitle, Faculty editFaculty) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int facultyId = findFacultyId(facultyTitle);
		if (!isExistFaculty(editFaculty.getTitle())) {
			try {
				connection = connectionPool.getConnection();
				connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement(SQL_UPDATE_FACULTY);
				editAllData(editFaculty, facultyTitle, connection);
				preparedStatement.setString(1, editFaculty.getTitle());
				preparedStatement.setInt(2, facultyId);
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (SQLException | ConnectionPoolException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					throw new DAOException("Error rolback editing faculty", e);
				}
				throw new DAOException("Error editing faculty in table", e);
			} finally {
				if (preparedStatement != null) {
					connectionPool.closePreparedStatement(preparedStatement);
				}
				try {
					connection.setAutoCommit(true);
					connectionPool.releaseConnection(connection);

				} catch (SQLException e) {
					throw new DAOException("Error commit editing faculty", e);
				}
			}
		}
	}

	private void editAllData(Faculty editFaculty, String facultyTitle, Connection connection) throws DAOException, SQLException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		daoProvider.getSubjectRequirementsDAO().editSubjectRequirements(connection, facultyTitle,
				editFaculty.getSubjectRequirements());
		daoProvider.getPlanRequirementsDAO().editPlanRequirements(connection, facultyTitle,
				editFaculty.getPlanRequirements());
	}

	@Override
	public int findFacultyId(String facultyTitle) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = -1;
		try {
			connection = connectionPool.getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			preparedStatement = connection.prepareStatement(SQL_SELECT_FACULTY_ID);
			preparedStatement.setString(1, facultyTitle);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of finding faculty in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

		return id;
	}

	@Override
	public String getFacultyTitle(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String title = "";
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_FACULTY_TITLE);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				title = resultSet.getString(1);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get faculty title from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}

		return title;
	}

	@Override
	public Faculty getFaculty(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		DAOProvider provider = DAOProvider.getInstance();
		Faculty faculty = new Faculty();
		ResultSet resultSet = null;

		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_FACULTY);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				faculty.setId(id);
				faculty.setTitle(resultSet.getString(2));
			}
			SubjectRequirements subjectRequirements = provider.getSubjectRequirementsDAO().getSubjectRequirements(id);
			PlanRequirements planRequirements = provider.getPlanRequirementsDAO().getPlanRequirements(id);
			faculty.setSubjectRequirements(subjectRequirements);
			faculty.setPlanRequirements(planRequirements);
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get faculty from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}
		return faculty;
	}

	@Override
	public ArrayList<Faculty> getFaculties() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Faculty> faculties = new ArrayList<>();
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_FACULTY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				Faculty faculty = getFaculty(id);
				faculties.add(faculty);
			}
			return faculties;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get faculties from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}
	}

}
