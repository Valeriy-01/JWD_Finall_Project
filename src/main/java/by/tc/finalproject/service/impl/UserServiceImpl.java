package by.tc.finalproject.service.impl;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.UserAccessDAO;
import by.tc.finalproject.dao.UserDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.service.UserService;
import by.tc.finalproject.service.exception.ServiceException;
import by.tc.finalproject.validator.impl.EmailValidator;
import by.tc.finalproject.validator.impl.PassportValidator;
import by.tc.finalproject.validator.impl.PasswordValidator;
import by.tc.finalproject.validator.impl.UserValidator;

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
					&& !userDAO.isExistUser(user.getPassport())) {
				userDAO.addUser(user, user.getFacultyTitle());
				registered = userDAO.isExistUser(user.getPassport());
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return registered;
	}

	@Override
	public boolean editing(String oldPassport, User user) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		boolean editing = false;
		try {
			if (UserValidator.getInstance().validate(user) && PassportValidator.getInstance().validate(oldPassport)
					&& !provider.getAdmissionResultDAO().isCreateEnrolleList()
					&& !userDAO.isExistUser(user.getPassport())) {
				userDAO.editUser(oldPassport, user.getFacultyTitle(), user);
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
