package by.tc.finalproject.service.impl;

import org.junit.Assert;
import org.junit.Test;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.service.ServiceProvider;
import by.tc.finalproject.service.exception.ServiceException;

public class UserServiceImplTest {

	/*
	 * Начальные условия : база данных содержит заданного пользователя
	 */

	@Test
	public void testAuthorizationX0001() throws ServiceException {
		String email = "goreglyad_01@mail.ru";
		String password = "wergj223vwe";

		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);

		User resultUser = ServiceProvider.getInstance().getUserService().authorization(email, password);

		Assert.assertTrue(resultUser.equals(user));
	}

	@Test
	public void testAuthorizationX0002() throws ServiceException {
		String email = "committee_01@mail.ru";
		String password = "";
		User resultUser = ServiceProvider.getInstance().getUserService().authorization(email, password);

		Assert.assertNull(resultUser);
	}

	/*
	 * Начальные условия : база данных содержит заданный факультет и не содержит
	 * заданного пользователя
	 */

	@Test
	public void testRegistrationX0001() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);
		user.setFacultyTitle("Факультет Компьютерного Проектирования");

		boolean result = ServiceProvider.getInstance().getUserService().registration(user);
		Assert.assertTrue(result);
	}

	@Test
	public void testRegistrationX0002() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, -9999, 98);
		User user = new User("", "Валерий", "ab452716", userAccess, state);

		boolean result = ServiceProvider.getInstance().getUserService().registration(user);
		Assert.assertFalse(result);
	}

	/*
	 * Начальные условия : база данных содержит заданного пользователя и факультет
	 */

	@Test
	public void testEditingX0001() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "Валерий", "ab452716", userAccess, state);
		user.setFacultyTitle("Факультет Компьютерного Проектирования");

		boolean result = ServiceProvider.getInstance().getUserService().editing(user.getPassport(), user);
		Assert.assertTrue(result);
	}

	@Test
	public void testEditingX0002() throws ServiceException {
		UserAccess userAccess = new UserAccess("goreglyad_01@mail.ru", "hfkgun48nvv");
		State state = new State(85, 97, 85, 98);
		User user = new User("Горегляд", "", "ab452716", userAccess, state);

		boolean result = ServiceProvider.getInstance().getUserService().editing(user.getPassport(), user);
		Assert.assertFalse(result);
	}

	/*
	 * Начальные условия : база данных содержит пользователя с заданным паспортом
	 */

	@Test
	public void testDeletingX0001() throws ServiceException {
		String passport = "ab452716";
		boolean result = ServiceProvider.getInstance().getUserService().deleting(passport);
		Assert.assertTrue(result);
	}

	@Test
	public void testDeletingX0002() throws ServiceException {
		String passport = null;
		boolean result = ServiceProvider.getInstance().getUserService().deleting(passport);
		Assert.assertFalse(result);
	}
}
