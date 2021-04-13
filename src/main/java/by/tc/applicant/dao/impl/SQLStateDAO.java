package by.tc.applicant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.applicant.bean.State;
import by.tc.applicant.dao.StateDAO;
import by.tc.applicant.dao.exception.DAOException;
import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.dao.pool.exception.ConnectionPoolException;

public class SQLStateDAO implements StateDAO {
	private static final String SQL_INSERT_STATE = "INSERT INTO state(student_id, sub_result_1,sub_result_2,sub_result_3,certificate_result,total_scope) VALUES(?,?,?,?,?,?)";
	private static final String SQL_UPDATE_STATE = "UPDATE state SET sub_result_1=?, sub_result_2=?, sub_result_3=?, certificate_result=?, total_scope=? WHERE student_id=?";
	private static final String SQL_DELETE_STATE = "DELETE FROM state WHERE student_id=?";
	private static final String SQL_SELECT_STATE = "SELECT * FROM state WHERE student_id=?";

	@Override
	public void addUserInState(Connection connection, State state) throws SQLException {
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
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}

	}

	@Override
	public void deleteState(Connection connection, int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_DELETE_STATE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting statement in table", e);
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);
			}
		}

	}

	@Override
	public void editStatement(Connection connection, int userId, State state) throws SQLException {
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
		} finally {
			if (preparedStatement != null) {
				connectionPool.closePreparedStatement(preparedStatement);

			}
		}
	}

	@Override
	public State getState(int id) throws DAOException {
		State state = new State();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT_STATE);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
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
				connectionPool.closePreparedStatement(preparedStatement);
			}
			if (resultSet != null) {
				connectionPool.closeResultSet(resultSet);
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
