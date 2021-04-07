package by.tc.finalproject.service.impl;

import org.junit.Assert;
import org.junit.Test;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class CommitteeServiceImplTest {

	/*
	 * Начальные условия : база данных содержит заданного администратора
	 */

	@Test
	public void testAuthorizationX0001() throws ServiceException {
		String email = "committee_01@mail.ru";
		String password = "ddsdfew32fv";
		boolean result = ServiceProvider.getInstance().getCommitteeService().authorization(email, password);
		Assert.assertTrue(result);
	}

	@Test
	public void testAuthorizationX0002() throws ServiceException {
		String email = "";
		String password = "ddsdfew32fv";
		boolean result = ServiceProvider.getInstance().getCommitteeService().authorization(email, password);
		Assert.assertFalse(result);
	}

	/*
	 * Начальные условия : база данных содержит заданного пользователя
	 */

	@Test
	public void testDeletingUserX0001() throws ServiceException {
		String passport = "ab3452385";
		boolean result = ServiceProvider.getInstance().getCommitteeService().deletingUser(passport);
		Assert.assertTrue(result);
	}

	@Test
	public void testDeletingUserX0002() throws ServiceException {
		String passport = "";
		boolean result = ServiceProvider.getInstance().getCommitteeService().deletingUser(passport);
		Assert.assertFalse(result);
	}

	/*
	 * Начальные условия : база данных содержит заданного пользователя
	 */

	@Test
	public void testEditingUserX0001() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);

		String passport = "ab3452385";
		boolean result = ServiceProvider.getInstance().getCommitteeService().editingUser(passport, user);
		Assert.assertTrue(result);
	}

	@Test
	public void testEditingUserX0002() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);

		String passport = "";
		boolean result = ServiceProvider.getInstance().getCommitteeService().editingUser(passport, user);
		Assert.assertFalse(result);
	}

}
