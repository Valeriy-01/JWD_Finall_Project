package by.tc.applicant.dao;

import by.tc.applicant.bean.Committee;
import by.tc.applicant.dao.exception.DAOException;

public interface CommitteeDAO {
	void addCommittee(Committee committee) throws DAOException;

	void deleteCommittee(String login) throws DAOException;

	boolean isExistCommittee(String email, String password) throws DAOException;

	void editCommittee(String login, Committee committee) throws DAOException;
}
