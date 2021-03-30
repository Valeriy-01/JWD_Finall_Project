package by.tc.finalproject.dao;

import java.sql.Connection;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.dao.exception.DAOException;

public interface AdmissionResultDAO {
	void addAdmissionResult(Connection connection, int id, AdmissionResult admissionResult) throws DAOException;

	void deleteAdmissionResult(Connection connection, int id) throws DAOException;

	void editAdmissionResult(String passport, AdmissionResult admissionResult) throws DAOException;

	AdmissionResult getAdmissionResult(String passport) throws DAOException;

	boolean isCreateEnrolleList() throws DAOException;
}
