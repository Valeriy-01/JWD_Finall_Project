package by.tc.applicant.service;

import by.tc.applicant.service.impl.CommitteeServiceImpl;
import by.tc.applicant.service.impl.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private final UserService userService = new UserServiceImpl();
	private final CommitteeService committeeService = new CommitteeServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public CommitteeService getCommitteeService() {
		return committeeService;
	}

}
