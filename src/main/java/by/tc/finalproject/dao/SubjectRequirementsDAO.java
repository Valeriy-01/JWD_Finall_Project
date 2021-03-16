package by.tc.finalproject.dao;

import by.tc.finalproject.bean.SubjectRequirements;
import by.tc.finalproject.dao.exception.DAOException;

public interface SubjectRequirementsDAO {
	boolean addSubjectRequirements(SubjectRequirements subjectRequirements) throws DAOException;

	boolean deleteSubjectRequirements(int id) throws DAOException;

	boolean editSubjectRequirements(String facultyTitle, SubjectRequirements subjectsRequirements) throws DAOException;
}
