package by.tc.finalproject.dao;

import java.sql.Connection;

import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.exception.DAOException;

public interface UserAccessDAO {
	void addUserAccess(Connection connection, UserAccess userAccess) throws DAOException;

	void deleteUserAccess(Connection connection, int id) throws DAOException;

	void editUserAccess(Connection connection, int userId, UserAccess editUserAccess) throws DAOException;

	boolean isExistLoginUserAccess(String email, String password) throws DAOException;

	int findUserAccessId(String email, String password) throws DAOException;

	UserAccess getUserAccess(int id) throws DAOException;
}
