package by.tc.finalproject.dao;

import java.sql.Connection;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.dao.exception.DAOException;

public interface StateDAO {
	void addUserInState(Connection connection, State state) throws DAOException;

	void deleteState(Connection connection, int id) throws DAOException;

	void editStatement(Connection connection, int userId, State state) throws DAOException;

	State getState(int id) throws DAOException;

	void updateStatement(State state, int studentId);
}
