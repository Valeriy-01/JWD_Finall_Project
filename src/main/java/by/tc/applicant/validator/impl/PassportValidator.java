package by.tc.applicant.validator.impl;

import java.util.function.Predicate;

import by.tc.applicant.validator.Validator;

public class PassportValidator implements Validator<String> {
	private static final String LOGIN_REGEX_PATTERN = "^[a-zA-Z0-9]+$";

	private static PassportValidator instance;

	public static PassportValidator getInstance() {
		if (instance == null) {
			instance = new PassportValidator();
		}
		return instance;
	}

	@Override
	public Boolean validate(final String input) {
		if (input == null) {
			return false;
		}
		Predicate<String> stringPredicate = str -> (StringLengthValidator.getInstance().validate(str)
				& str.matches(LOGIN_REGEX_PATTERN));
		return stringPredicate.test(input);
	}
}
