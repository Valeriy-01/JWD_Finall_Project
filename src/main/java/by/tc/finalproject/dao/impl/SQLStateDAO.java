package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.dao.StateDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLStateDAO implements StateDAO {
	private static final String SQL_INSERT_STATE = "INSERT INTO committee.state(student_id, sub_result_1,sub_result_2,sub_result_3,certificate_result,total_scope) VALUES(?,?,?,?,?,?)";
	private static final String SQL_UPDATE_STATE = "UPDATE committee.state SET sub_result_1=?, sub_result_2=?, sub_result_3=?, certificate_result=?, total_scope=? WHERE student_id=?";
	private static final String SQL_DELETE_STATE = "DELETE FROM committee.state WHERE student_id=?";
	private static final String SQL_SELECT_STATE = "SELECT * FROM committee.state WHERE student_id=?";

	@Override
	public void addUserInState(Connection connection, State state) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERT_STATE);
			preparedStatement.setInt(1, state.getStudentId());
			preparedStatement.setInt(2, state.getFirstSubjectResult());
			preparedStatement.setInt(3, state.getSecondSubjectResult());
			preparedStatement.setInt(4, state.getThirdSubjectResult());
			preparedStatement.setInt(5, state.getCertificateResult());
			preparedStatement.setInt(6, countTotalScope(state));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while writing statement in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
		}

	}

	@Override
	public void deleteState(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_STATE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting statement in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

	}

	@Override
	public void editStatement(Connection connection, int userId, State state) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_UPDATE_STATE);
			preparedStatement.setInt(1, state.getFirstSubjectResult());
			preparedStatement.setInt(2, state.getSecondSubjectResult());
			preparedStatement.setInt(3, state.getThirdSubjectResult());
			preparedStatement.setInt(4, state.getCertificateResult());
			preparedStatement.setInt(5, countTotalScope(state));
			preparedStatement.setInt(6, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error editing statement in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
		}
	}

	@Override
	public State getState(int id) throws DAOException {
		State state = new State();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_STATE);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				state.setStudentId(id);
				state.setFirstSubjectResult(resultSet.getInt(2));
				state.setSecondSubjectResult(resultSet.getInt(3));
				state.setThirdSubjectResult(resultSet.getInt(4));
				state.setCertificateResult(resultSet.getInt(5));
				state.setTotalScope(resultSet.getInt(6));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error get state from table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closeConnection(preparedStatement);
			}
			connectionPool.releaseConnection(connection);
		}

		return state;
	}

	@Override
	public void updateStatement(State state, int studentId) {
		int totalScope = state.getFirstSubjectResult() + state.getSecondSubjectResult() + state.getThirdSubjectResult()
				+ state.getThirdSubjectResult();
		state.setTotalScope(totalScope);

		state.setStudentId(studentId);
	}

	private int countTotalScope(State state) {
		return state.getFirstSubjectResult() + state.getSecondSubjectResult() + state.getThirdSubjectResult()
				+ state.getCertificateResult();
	}
}