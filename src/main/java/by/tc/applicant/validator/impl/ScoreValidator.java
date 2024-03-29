package by.tc.applicant.validator.impl;

import java.util.function.Predicate;

import by.tc.applicant.validator.Validator;

public class ScoreValidator implements Validator<Integer> {

	private static ScoreValidator instance;

	private static final int max = 101;
	private static final int min = -1;

	public static ScoreValidator getInstance() {
		if (instance == null) {
			instance = new ScoreValidator();
		}

		return instance;
	}

	@Override
	public Boolean validate(final Integer input) {
		if (input == null) {
			return false;
		}
		Predicate<Integer> integerPredicate = integer -> integer > min && integer < max;
		return integerPredicate.test(input);
	}
}
