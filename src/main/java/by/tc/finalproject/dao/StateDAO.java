package by.tc.finalproject.dao;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.TransferUser;
import by.tc.finalproject.dao.exception.DAOException;

public interface StateDAO {
	boolean addUserInState(State state) throws DAOException;

	boolean deleteState(int id) throws DAOException;

	boolean editStatement(int userId, State state) throws DAOException;

	State getState(int id) throws DAOException;

	void updateStatement(State state, int studentId);

	void getState(TransferUser transferUser, int id) throws DAOException;

}
