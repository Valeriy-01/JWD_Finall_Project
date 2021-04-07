package by.tc.finalproject.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import by.tc.finalproject.dao.impl.SQLCommitteeDAOTest;
import by.tc.finalproject.dao.impl.SQLFacultyDAOTest;
import by.tc.finalproject.dao.impl.SQLUserDAOTest;
import by.tc.finalproject.validator.impl.EmailValidatorTest;
import by.tc.finalproject.validator.impl.NameValidatorTest;
import by.tc.finalproject.validator.impl.PassportValidatorTest;
import by.tc.finalproject.validator.impl.PasswordValidatorTest;
import by.tc.finalproject.validator.impl.ScoreValidatorTest;
import by.tc.finalproject.validator.impl.UserValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({ SQLUserDAOTest.class,SQLCommitteeDAOTest.class,SQLFacultyDAOTest.class,EmailValidatorTest.class, NameValidatorTest.class, PassportValidatorTest.class,
		PasswordValidatorTest.class, ScoreValidatorTest.class, UserValidatorTest.class})

public class TestSuite {

	public static void main(String[] args) {
	}
}
