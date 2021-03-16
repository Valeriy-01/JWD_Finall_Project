package by.tc.finalproject.service;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.service.exception.ServiceException;

public interface UserService {
	boolean authorization(String email, String password) throws ServiceException;

	boolean registration(User user,UserAccess userAccess,State state,String facultyTitle) throws ServiceException;
}
