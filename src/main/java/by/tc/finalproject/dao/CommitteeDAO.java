package by.tc.finalproject.dao;

import by.tc.finalproject.bean.Committee;
import by.tc.finalproject.dao.exception.DAOException;

public interface CommitteeDAO {
	void addCommittee(Committee committee) throws DAOException;

	void deleteCommittee(String login) throws DAOException;

	boolean isExistCommittee(String email, String password) throws DAOException;

	void editCommittee(String login, Committee committee) throws DAOException;
}
