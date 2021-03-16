package by.tc.finalproject.dao;

import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface PlanRequirementsDAO {
	boolean addPlanRequirements(PlanRequirements planRequirements) throws DAOException;

	boolean deletePlanRequirements(int id) throws DAOException;

	boolean editPlanRequirements(String facultyTitle, PlanRequirements planRequirements) throws DAOException;
}
