package by.tc.finalproject.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface PlanRequirementsDAO {
	void addPlanRequirements(Connection connection, PlanRequirements planRequirements) throws SQLException;

	void deletePlanRequirements(Connection connection, int id) throws DAOException;

	void editPlanRequirements(Connection connection, String facultyTitle, PlanRequirements planRequirements)
			throws SQLException, DAOException;

	PlanRequirements getPlanRequirements(int id) throws DAOException;
}
