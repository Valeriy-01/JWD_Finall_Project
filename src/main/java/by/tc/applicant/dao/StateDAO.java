package by.tc.applicant.dao;

import java.sql.Connection;
import java.sql.SQLException;

import by.tc.applicant.bean.State;
import by.tc.applicant.dao.exception.DAOException;

public interface StateDAO {

	void deleteState(Connection connection, int id) throws DAOException;

	void editStatement(Connection connection, int userId, State state) throws SQLException;

	void addUserInState(Connection connection, State state) throws SQLException;

	State getState(int id) throws DAOException;

	void updateStatement(State state, int studentId);
}
