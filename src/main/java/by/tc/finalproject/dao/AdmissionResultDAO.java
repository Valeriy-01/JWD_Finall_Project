package by.tc.finalproject.dao;

import by.tc.finalproject.bean.AdmissionResult;
import by.tc.finalproject.dao.exception.DAOException;

public interface AdmissionResultDAO {
	boolean addUserInState(String passport, AdmissionResult admissionResult) throws DAOException;
	boolean deleteAdmissionResult(int id) throws DAOException;
	boolean editAdmissionResult(String passport, AdmissionResult admissionResult) throws DAOException;
}
