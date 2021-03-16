package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	@Override
	public boolean addPlanRequirements(PlanRequirements planRequirements) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PLAN)) {
			preparedStatement.setInt(1, planRequirements.getId());
			preparedStatement.setInt(2, planRequirements.getDialPlan());
			preparedStatement.setInt(3, planRequirements.getPassingScope());
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing plan requirements to table", e);
		}
	}

	@Override
	public boolean deletePlanRequirements(int id) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PLAN)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting plan requirements in table", e);
		}
	}

	@Override
	public boolean editPlanRequirements(String facultyTitle, PlanRequirements planRequirements) throws DAOException {
		int facultyId = DAOProvider.getInstance().getFacultyDAO().findFacultyId(facultyTitle);
		try (	Connection connection = ConnectionPool.getInstance().getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PLAN)) {
			preparedStatement.setInt(1, planRequirements.getDialPlan());
			preparedStatement.setInt(2, planRequirements.getPassingScope());
			preparedStatement.setInt(3, facultyId);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing plan requirements in table", e);
		}
	}

}
