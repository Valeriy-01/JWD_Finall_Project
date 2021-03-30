package by.tc.finalproject.dao;

import java.util.ArrayList;

import by.tc.finalproject.bean.User;
import by.tc.finalproject.dao.exception.DAOException;

public interface UserDAO {
	void addUser(User user, String facultyTitle) throws DAOException;

	boolean isExistUser(String passport) throws DAOException;

	void deleteUser(String passport) throws DAOException;

	int findUserId(String passport) throws DAOException;

	void editUser(String passport, String userFaculty, User editUser) throws DAOException;
	
	int getNextMaxUserID() throws DAOException;
	 
	User getUser(int id) throws DAOException;

	ArrayList<User> getUsers() throws DAOException;

	ArrayList<User> getUsers(int facultyId) throws DAOException;

}
