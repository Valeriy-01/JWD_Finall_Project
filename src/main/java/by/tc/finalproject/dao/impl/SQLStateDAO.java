package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.TransferUser;
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
	public boolean addUserInState(State state) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_STATE)) {
			preparedStatement.setInt(1, state.getStudentId());
			preparedStatement.setInt(2, state.getFirstSubjectResult());
			preparedStatement.setInt(3, state.getSecondSubjectResult());
			preparedStatement.setInt(4, state.getThirdSubjectResult());
			preparedStatement.setInt(5, state.getCertificateResult());
			preparedStatement.setInt(6, countTotalScope(state));
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error while writing statement to table", e);
		}

	}

	@Override
	public boolean deleteState(int id) throws DAOException {

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_STATE)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting statement in table", e);
		}

	}

	@Override
	public boolean editStatement(int userId, State state) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_STATE)) {
			preparedStatement.setInt(1, state.getFirstSubjectResult());
			preparedStatement.setInt(2, state.getSecondSubjectResult());
			preparedStatement.setInt(3, state.getThirdSubjectResult());
			preparedStatement.setInt(4, state.getCertificateResult());
			preparedStatement.setInt(5, countTotalScope(state));
			preparedStatement.setInt(6, userId);

			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing statement in table", e);
		}
	}

	@Override
	public State getState(int id) throws DAOException {
		State state = new State();

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_STATE)) {
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
			throw new DAOException("Error of finding user in table", e);
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

	@Override
	public void getState(TransferUser transferUser, int id) throws DAOException {

		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_STATE)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				transferUser.setTotalScope(resultSet.getInt(6));
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error of get state in table", e);
		}

	}
}
