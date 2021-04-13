package by.tc.applicant.dao;

import by.tc.applicant.dao.impl.SQLAdmissionResultDAO;
import by.tc.applicant.dao.impl.SQLCommitteeDAO;
import by.tc.applicant.dao.impl.SQLFacultyDAO;
import by.tc.applicant.dao.impl.SQLPlanRequirementsDAO;
import by.tc.applicant.dao.impl.SQLStateDAO;
import by.tc.applicant.dao.impl.SQLSubjectRequirementsDAO;
import by.tc.applicant.dao.impl.SQLUserAccessDAO;
import by.tc.applicant.dao.impl.SQLUserDAO;

public class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	private final AdmissionResultDAO admissionResultDAO = new SQLAdmissionResultDAO();
	private final CommitteeDAO committeeDAO = new SQLCommitteeDAO();
	private final FacultyDAO facultyDAO = new SQLFacultyDAO();
	private final PlanRequirementsDAO planRequirementsDAO = new SQLPlanRequirementsDAO();
	private final StateDAO stateDAO = new SQLStateDAO();
	private final SubjectRequirementsDAO subjectRequirementsDAO = new SQLSubjectRequirementsDAO();
	private final UserAccessDAO userAccessDAO = new SQLUserAccessDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public AdmissionResultDAO getAdmissionResultDAO() {
		return admissionResultDAO;
	}

	public CommitteeDAO getCommitteeDAO() {
		return committeeDAO;
	}

	public FacultyDAO getFacultyDAO() {
		return facultyDAO;
	}

	public PlanRequirementsDAO getPlanRequirementsDAO() {
		return planRequirementsDAO;
	}

	public StateDAO getStateDAO() {
		return stateDAO;
	}

	public SubjectRequirementsDAO getSubjectRequirementsDAO() {
		return subjectRequirementsDAO;
	}

	public UserAccessDAO getUserAccessDAO() {
		return userAccessDAO;
	}

}
