package by.tc.finalproject.dao;

import java.util.ArrayList;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.TransferUser;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.exception.DAOException;

public interface UserDAO {
	boolean addUser(User user, UserAccess userAccess, State state, String facultyTitle) throws DAOException;

	boolean isExistUser(String passport) throws DAOException;

	boolean deleteUser(String passport) throws DAOException;

	int findUserId(String passport) throws DAOException;

	boolean editUser(String passport, String userFaculty, User editUser, State editState, UserAccess editUserAccess)
			throws DAOException;

	User getUser(int id) throws DAOException;

	ArrayList<TransferUser> getUsers() throws DAOException;
}
