package by.tc.finalproject.service;

import java.util.ArrayList;

import by.tc.finalproject.bean.User;
import by.tc.finalproject.service.exception.ServiceException;

public interface CommitteeService {
	boolean authorization(String email, String password) throws ServiceException;

	ArrayList<User> viewApplicants() throws ServiceException;

	boolean deletingUser(String passport) throws ServiceException;

	boolean editingUser(String passport, User user) throws ServiceException;

	User selectUser(String passport) throws ServiceException;

	void formListOfEnrolled() throws ServiceException;

}
