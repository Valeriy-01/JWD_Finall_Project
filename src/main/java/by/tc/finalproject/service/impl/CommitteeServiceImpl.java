package by.tc.finalproject.service.impl;

import java.util.*;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.bean.Faculty;
import by.tc.finalproject.bean.PlanRequirements;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.dao.CommitteeDAO;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.UserDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.service.CommitteeService;
import by.tc.finalproject.service.comparator.UserScopeComparator;
import by.tc.finalproject.service.exception.ServiceException;
import by.tc.finalproject.validator.impl.EmailValidator;
import by.tc.finalproject.validator.impl.PassportValidator;
import by.tc.finalproject.validator.impl.UserValidator;

public class CommitteeServiceImpl implements CommitteeService {

	private static final int ENTERED_CONDITION = 1;
	private static final int NO_ENTERED_CONDITION = 0;

	@Override
	public boolean authorization(String email, String password) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		CommitteeDAO committeeDAO = provider.getCommitteeDAO();
		try {
			if (EmailValidator.getInstance().validate(email) || EmailValidator.getInstance().validate(password)) {
				return committeeDAO.isExistCommittee(email, password);
			}
			return false;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ArrayList<User> viewApplicants() throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		try {
			ArrayList<User> users = userDAO.getUsers();
			return users;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deletingUser(String passport) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		boolean deleting = false;
		try {
			if (PassportValidator.getInstance().validate(passport) && userDAO.isExistUser(passport)) {
				userDAO.deleteUser(passport);
				deleting = !userDAO.isExistUser(passport);
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return deleting;
	}

	@Override
	public boolean editingUser(String passport, User user) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		boolean editing = false;
		try {
			if (UserValidator.getInstance().validate(user) && PassportValidator.getInstance().validate(passport)
					&& !userDAO.isExistUser(user.getPassport())) {
				userDAO.editUser(passport, user.getFacultyTitle(), user);
				editing = userDAO.isExistUser(user.getPassport());
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return editing;
	}

	@Override
	public User selectUser(String passport) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		User user;
		try {
			if (!PassportValidator.getInstance().validate(passport)) {
				return null;
			}
			int id = userDAO.findUserId(passport);
			user = userDAO.getUser(id);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void formListOfEnrolled() throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		try {
			ArrayList<User> users;
			ArrayList<Faculty> faculties = provider.getFacultyDAO().getFaculties();
			UserScopeComparator userScopeComparator = new UserScopeComparator();
			int plan;
			int passingScope = 0;
			for (int i = 0; i < faculties.size(); i++) {
				plan = faculties.get(i).getPlanRequirements().getDialPlan();
				users = provider.getUserDAO().getUsers(faculties.get(i).getId());
				users.sort(userScopeComparator);
				passingScope = findPassingScope(plan, users, provider);
				updatePassingScope(passingScope, faculties.get(i));
				provider.getFacultyDAO().editFaculty(faculties.get(i).getTitle(), faculties.get(i));
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	private int findPassingScope(int plan, ArrayList<User> users, DAOProvider provider) throws ServiceException {
		int index;
		int passingScope = 0;
		try {
			for (index = 0; index < users.size(); index++) {
				plan--;
				formEnteredEnrolle(provider, users.get(index));
				if (plan == 0) {
					passingScope = users.get(index).getState().getTotalScope();
					index++;
					break;
				}
			}
			while (index < users.size()) {
				formNoEnteredEnrolle(provider, users.get(index));
				index++;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return passingScope;
	}

	private void updatePassingScope(int passingScope, Faculty faculty) {
		PlanRequirements planRequirements = faculty.getPlanRequirements();
		planRequirements.setPassingScope(passingScope);
	}

	private void formEnteredEnrolle(DAOProvider provider, User user) throws DAOException {
		// EmailServiceImpl.getInstance().sendMessage(user.getUserAccess().getEmail());
		provider.getAdmissionResultDAO().editAdmissionResult(user.getPassport(),
				new AdmissionResult(ENTERED_CONDITION));
	}

	private void formNoEnteredEnrolle(DAOProvider provider, User user) throws DAOException {
		// EmailServiceImpl.getInstance().sendMessage(user.getUserAccess().getEmail());
		provider.getAdmissionResultDAO().editAdmissionResult(user.getPassport(),
				new AdmissionResult(NO_ENTERED_CONDITION));
	}

}
