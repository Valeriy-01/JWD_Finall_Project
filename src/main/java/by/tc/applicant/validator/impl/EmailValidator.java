package by.tc.applicant.validator.impl;

import java.util.function.Predicate;

import by.tc.applicant.validator.Validator;

public class EmailValidator implements Validator<String> {
	private static final String EMAIL_REGEX_PATTERN = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

	private static EmailValidator instance;

	public static EmailValidator getInstance() {

		if (instance == null) {
			instance = new EmailValidator();
		}

		return instance;
	}

	@Override
	public Boolean validate(final String input) {
		if (input == null) {
			return false;
		}
		Predicate<String> stringPredicate = str -> (StringLengthValidator.getInstance().validate(str)
				& str.matches(EMAIL_REGEX_PATTERN));
		return stringPredicate.test(input);
	}
}
