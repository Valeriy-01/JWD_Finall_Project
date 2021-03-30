package by.tc.finalproject.service.comparator;

import java.util.Comparator;

import by.tc.finalproject.bean.User;

public class UserScopeComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		int scopeFirstUser = o1.getState().getTotalScope();
		int scopeSecondUser = o2.getState().getTotalScope();
		if (scopeFirstUser < scopeSecondUser) {
			return 1;
		} else if (scopeFirstUser == scopeSecondUser) {
			return 0;
		} else {
			return -1;
		}
	}

}
