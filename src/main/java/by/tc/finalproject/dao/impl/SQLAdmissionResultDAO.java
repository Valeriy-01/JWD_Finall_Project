package by.tc.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.dao.AdmissionResultDAO;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class SQLAdmissionResultDAO implements AdmissionResultDAO {
	private static final String SQL_INSERT_ADMISSION = "INSERT INTO committee.admission_result(student_id, result) VALUES(?,?)";
	private static final String SQL_UPDATE_ADMISSION = "UPDATE committee.admission_result SET result=? WHERE student_id=?";
	private static final String SQL_DELETE_ADMISSION = "DELETE FROM committee.admission_result WHERE id=?";

	@Override
	public boolean addUserInState(String passport, AdmissionResult admissionResult) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ADMISSION)) {
			int result = getResult(admissionResult);
			int id = DAOProvider.getInstance().getUserDAO().findUserId(passport);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, result);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error add admission result in table", e);
		}
	}

	@Override
	public boolean deleteAdmissionResult(int id) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ADMISSION)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.execute();

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error deleting admission result in table", e);
		}

	}

	private int getResult(AdmissionResult admissionResult) {
		if (admissionResult.isAdmissionResult()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean editAdmissionResult(String passport, AdmissionResult admissionResult) throws DAOException {
		try (Connection connection = ConnectionPool.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ADMISSION)) {
			int userId = DAOProvider.getInstance().getUserDAO().findUserId(passport);
			preparedStatement.setInt(1, getResult(admissionResult));
			preparedStatement.setInt(2, userId);
			return preparedStatement.execute();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Error editing admission result in table", e);
		}
	}

}
