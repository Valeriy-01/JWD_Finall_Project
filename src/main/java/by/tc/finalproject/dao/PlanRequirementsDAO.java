package by.tc.finalproject.dao;

import java.sql.Connection;

import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface PlanRequirementsDAO {
	void addPlanRequirements(Connection connection, PlanRequirements planRequirements) throws DAOException;

	void deletePlanRequirements(Connection connection,int id) throws DAOException;

	void editPlanRequirements(Connection connection, String facultyTitle, PlanRequirements planRequirements)
			throws DAOException;

	PlanRequirements getPlanRequirements(int id) throws DAOException;
}
