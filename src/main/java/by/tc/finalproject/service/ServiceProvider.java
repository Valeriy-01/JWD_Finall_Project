package by.tc.finalproject.service;

import by.tc.finalproject.service.impl.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {
	}

	private final UserService userService = new UserServiceImpl();

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
}
