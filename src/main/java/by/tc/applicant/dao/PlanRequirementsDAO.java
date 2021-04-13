package by.tc.applicant.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.applicant.bean.PlanRequirements;
import by.tc.applicant.dao.exception.DAOException;

public interface PlanRequirementsDAO {
	void addPlanRequirements(Connection connection, PlanRequirements planRequirements) throws SQLException;

	void deletePlanRequirements(Connection connection, int id) throws DAOException;

	void editPlanRequirements(Connection connection, String facultyTitle, PlanRequirements planRequirements)
			throws SQLException, DAOException;

	PlanRequirements getPlanRequirements(int id) throws DAOException;
}
