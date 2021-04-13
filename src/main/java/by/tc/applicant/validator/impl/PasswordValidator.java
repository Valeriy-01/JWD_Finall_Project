package by.tc.applicant.validator.impl;

import java.util.function.Predicate;

import by.tc.applicant.validator.Validator;

public class PasswordValidator implements Validator<String> {
	private static final int max = 256;
	private static final int min = 7;
	private static PasswordValidator instance;

	public static PasswordValidator getInstance() {

		if (instance == null) {
			instance = new PasswordValidator();
		}
		return instance;
	}

	@Override
	public Boolean validate(final String input) {
		if (input == null) {
			return false;
		}
		Predicate<String> stringPredicate = str -> (str.length() > min && str.length() < max);
		return stringPredicate.test(input);
	}
}
