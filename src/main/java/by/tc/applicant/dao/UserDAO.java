package by.tc.applicant.dao;

import java.util.ArrayList;

import by.tc.applicant.bean.User;
import by.tc.applicant.dao.exception.DAOException;

public interface UserDAO {
	void addUser(User user, String facultyTitle) throws DAOException;

	boolean isExistUser(String passport) throws DAOException;

	void deleteUser(String passport) throws DAOException;

	int findUserId(String passport) throws DAOException;

	void editUser(String passport, String userFaculty, User editUser) throws DAOException;

	User getUser(int id) throws DAOException;

	int getNextMaxUserID() throws DAOException;

	ArrayList<User> getUsers() throws DAOException;

	ArrayList<User> getUsers(int facultyId) throws DAOException;

}
