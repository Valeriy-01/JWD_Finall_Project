package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.PlanRequirementsDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLPlanRequirementsDAO implements PlanRequirementsDAO {

	private static final String SQL_INSERT_PLAN = "INSERT INTO committee.plan_requirements(id,dial_plan, passing_scope) VALUES(?,?,?)";
	private static final String SQL_UPDATE_PLAN = "UPDATE committee.plan_requirements SET dial_plan=?,passing_scope=? WHERE id=?";
	private static final String SQL_DELETE_PLAN = "DELETE FROM committee.plan_requirements WHERE id=?";
	private static final String SQL_SELECT_PLAN = "SELECT * FROM committee.plan_requirements WHERE id=?";

	@Override
	public void addPlanRequirements(Connection connection, PlanRequirements planRequirements) throws SQLException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERT_PLAN);
			preparedStatement.setInt(1, planRequirements.getId());
			preparedStatement.setInt(2, planRequirements.getDialPlan());
			preparedStatement.setInt(3, planRequirements.getPassingScope());
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public void deletePlanRequirements(Connection connection, int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_DELETE_PLAN);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting plan requirements in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public void editPlanRequirements(Connection connection, String facultyTitle, PlanRequirements planRequirements)
			throws SQLException, DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);
		try {
			preparedStatement = connection.prepareStatement(SQL_UPDATE_PLAN);
			preparedStatement.setInt(1, planRequirements.getDialPlan());
			preparedStatement.setInt(2, planRequirements.getPassingScope());
			preparedStatement.setInt(3, facultyId);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}
	}

	@Override
	public PlanRequirements getPlanRequirements(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PlanRequirements planRequirements = new PlanRequirements();
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_PLAN);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				planRequirements.setId(id);
				planRequirements.setDialPlan(resultSet.getInt(2));
				planRequirements.setPassingScope(resultSet.getInt(3));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get plan requirements from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
			}
			connectionPool.releaseConnection(connection);
		}
		return planRequirements;
	}

}
