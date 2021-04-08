package by.tc.finalproject.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.exception.DAOException;

public interface UserAccessDAO {

	void deleteUserAccess(Connection connection, int id) throws DAOException;

	void editUserAccess(Connection connection, int userId, UserAccess editUserAccess) throws SQLException;

	void addUserAccess(Connection connection, UserAccess userAccess) throws SQLException;

	boolean isExistLoginUserAccess(String email, String password) throws DAOException;

	boolean isExistUserByEmail(String email) throws DAOException;

	int findUserAccessId(String email, String password) throws DAOException;

	UserAccess getUserAccess(int id) throws DAOException;
}
