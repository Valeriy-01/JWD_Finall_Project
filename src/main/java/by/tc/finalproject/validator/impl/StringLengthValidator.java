package by.tc.finalproject.validator.impl;

import java.util.function.Predicate;

import by.tc.finalproject.validator.Validator;

public class StringLengthValidator implements Validator<String> {

	private static final int maxLength = 75;
	private static final int minxLength = 1;
	private static StringLengthValidator instance;

	public static StringLengthValidator getInstance() {
		if (instance == null) {
			instance = new StringLengthValidator();
		}

		return instance;
	}

	@Override
	public Boolean validate(final String input) {
		Predicate<String> stringPredicate = str -> (!str.isEmpty() & str.length() < maxLength
				& str.length() > minxLength);
		return stringPredicate.test(input);
	}
}
