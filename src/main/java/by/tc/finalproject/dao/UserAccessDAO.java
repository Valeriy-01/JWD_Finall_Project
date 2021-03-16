package by.tc.finalproject.dao;

import by.tc.finalproject.bean.TransferUser;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.exception.DAOException;

public interface UserAccessDAO {
	boolean addUserAccess(UserAccess userAccess) throws DAOException;

	boolean deleteUserAccess(int id) throws DAOException;

	boolean editUserAccess(int userId, UserAccess editUserAccess) throws DAOException;

	boolean isExistLoginUserAccess(String email, String password) throws DAOException;

	int findUserAccessId(String email, String password) throws DAOException;

	UserAccess getUserAccess(int id) throws DAOException;

	void getUserAccess(TransferUser transferUser, int id) throws DAOException;
}
