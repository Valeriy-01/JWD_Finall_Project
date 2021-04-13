package by.tc.applicant.validator.impl;

import org.junit.Assert;
import org.junit.Test;

import by.tc.applicant.bean.State;
import by.tc.applicant.bean.User;
import by.tc.applicant.bean.UserAccess;

public class UserValidatorTest {
	@Test
	public void testValidateX0() {
		State state = new State(1, 68, 90, 100);
		UserAccess userAccess = new UserAccess("alex_09@bk.ru", "wgw233ggh55");
		User user = new User();
		user.setName("Alex");
		user.setSurname("Andros");
		user.setPassport("ab789534");
		user.setState(state);
		user.setUserAccess(userAccess);
		Assert.assertTrue(UserValidator.getInstance().validate(user));

	}

	@Test
	public void testValidateX1() {
		State state = new State(1, 68, 90, 100);
		UserAccess userAccess = new UserAccess("alex_09bk.ru", "wgw233ggh55");
		User user = new User();
		user.setName("Alex");
		user.setSurname("Andros");
		user.setPassport("789534");
		user.setState(state);
		user.setUserAccess(userAccess);
		Assert.assertFalse(UserValidator.getInstance().validate(user));
	}

}
