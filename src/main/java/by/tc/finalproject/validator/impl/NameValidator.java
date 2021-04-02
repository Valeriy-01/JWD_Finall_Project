package by.tc.finalproject.validator.impl;

import java.util.function.Predicate;

import by.tc.finalproject.validator.Validator;

public class NameValidator implements Validator<String> {
	private static final String NAME_REGEX_PATTERN = "^([А-ЯЁ][а-яё]{1,75}|[A-Z][a-z]{1,75})$";

	private static NameValidator instance;

	public static NameValidator getInstance() {
		if (instance == null) {
			instance = new NameValidator();
		}
		return instance;
	}

	@Override
	public Boolean validate(final String input) {
		Predicate<String> stringPredicate = str -> (StringLengthValidator.getInstance().validate(str)
				& str.matches(NAME_REGEX_PATTERN));
		return stringPredicate.test(input);
	}
}