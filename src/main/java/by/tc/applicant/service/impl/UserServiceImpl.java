package by.tc.applicant.service.impl;

import by.tc.applicant.bean.AdmissionResult;
import by.tc.applicant.bean.User;
import by.tc.applicant.dao.DAOProvider;
import by.tc.applicant.dao.UserAccessDAO;
import by.tc.applicant.dao.UserDAO;
import by.tc.applicant.dao.exception.DAOException;
import by.tc.applicant.service.UserService;
import by.tc.applicant.service.exception.ServiceException;
import by.tc.applicant.validator.impl.EmailValidator;
import by.tc.applicant.validator.impl.PassportValidator;
import by.tc.applicant.validator.impl.PasswordValidator;
import by.tc.applicant.validator.impl.UserValidator;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String email, String password) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserAccessDAO userAccessDAO = provider.getUserAccessDAO();
		UserDAO userDAO = provider.getUserDAO();
		try {
			int id = -1;
			if (!PasswordValidator.getInstance().validate(password) || !EmailValidator.getInstance().validate(email)
					|| (id = userAccessDAO.findUserAccessId(email, password)) < 0) {
				return null;
			}
			User user = userDAO.getUser(id);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean registration(User user) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		boolean registered = false;
		try {
			if (UserValidator.getInstance().validate(user) && !provider.getAdmissionResultDAO().isCreateEnrolleList()
					&& !userDAO.isExistUser(user.getPassport())
					&& !provider.getUserAccessDAO().isExistUserByEmail(user.getUserAccess().getEmail())) {
				userDAO.addUser(user, user.getFacultyTitle());
				registered = userDAO.isExistUser(user.getPassport());
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return registered;
	}

	@Override
	public boolean editing(String passport, User user) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		boolean editing = false;
		try {
			if (UserValidator.getInstance().validate(user) && PassportValidator.getInstance().validate(passport)
					&& !provider.getAdmissionResultDAO().isCreateEnrolleList()) {
				userDAO.editUser(passport, user.getFacultyTitle(), user);
				editing = userDAO.isExistUser(user.getPassport());
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return editing;
	}

	@Override
	public boolean deleting(String passport) throws ServiceException {
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
	public int checkEnrolled(String passport) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		try {
			AdmissionResult admissionResult = provider.getAdmissionResultDAO().getAdmissionResult(passport);
			return admissionResult.getAdmissionResult();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
