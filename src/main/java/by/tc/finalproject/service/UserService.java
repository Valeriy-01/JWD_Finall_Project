package by.tc.finalproject.service;

import by.tc.finalproject.bean.User;
import by.tc.finalproject.service.exception.ServiceException;

public interface UserService {
	User authorization(String email, String password) throws ServiceException;

	boolean registration(User user) throws ServiceException;

	boolean editing(String oldPassport, User user) throws ServiceException;

	boolean deleting(String passport) throws ServiceException;

	int checkEnrolled(String passport) throws ServiceException;

}
