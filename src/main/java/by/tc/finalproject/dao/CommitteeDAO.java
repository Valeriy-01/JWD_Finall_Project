package by.tc.finalproject.dao;

import by.tc.finalproject.bean.Committee;
import by.tc.finalproject.dao.exception.DAOException;

public interface CommitteeDAO {
	boolean addCommittee(Committee committee) throws DAOException;

	boolean deleteCommittee(String login) throws DAOException;

	boolean isExistCommittee(String email, String password) throws DAOException;

	boolean editCommittee(String login, Committee committee) throws DAOException;
}
