package by.tc.applicant.dao;

import java.sql.Connection;

import by.tc.applicant.bean.AdmissionResult;
import by.tc.applicant.dao.exception.DAOException;

public interface AdmissionResultDAO {
	void addAdmissionResult(Connection connection, int id, AdmissionResult admissionResult) throws DAOException;

	void deleteAdmissionResult(Connection connection, int id) throws DAOException;

	void editAdmissionResult(String passport, AdmissionResult admissionResult) throws DAOException;

	AdmissionResult getAdmissionResult(String passport) throws DAOException;

	boolean isCreateEnrolleList() throws DAOException;
}
