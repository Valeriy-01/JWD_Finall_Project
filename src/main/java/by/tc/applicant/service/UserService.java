package by.tc.applicant.service;

import by.tc.applicant.bean.User;
import by.tc.applicant.service.exception.ServiceException;

public interface UserService {
	User authorization(String email, String password) throws ServiceException;

	boolean registration(User user) throws ServiceException;

	boolean editing(String oldPassport, User user) throws ServiceException;

	boolean deleting(String passport) throws ServiceException;

	int checkEnrolled(String passport) throws ServiceException;

}
