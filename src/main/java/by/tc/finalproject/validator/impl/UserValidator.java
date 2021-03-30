package by.tc.finalproject.validator.impl;

import by.tc.finalproject.bean.User;
import by.tc.finalproject.validator.Validator;

public class UserValidator implements Validator<User> {
	private static final ScoreValidator scoreValidator = ScoreValidator.getInstance();
	private static UserValidator instance;

	public static UserValidator getInstance() {
		if (instance == null) {
			instance = new UserValidator();
		}

		return instance;
	}

	@Override
	public Boolean validate(final User user) {
		return PassportValidator.getInstance().validate(user.getPassport())
				&& PasswordValidator.getInstance().validate(user.getUserAccess().getPassword())
				&& NameValidator.getInstance().validate(user.getName())
				&& NameValidator.getInstance().validate(user.getSurname())
				&& EmailValidator.getInstance().validate(user.getUserAccess().getEmail())
				&& scoreValidator.validate(user.getState().getCertificateResult())
				&& scoreValidator.validate(user.getState().getFirstSubjectResult())
				&& scoreValidator.validate(user.getState().getSecondSubjectResult())
				&& scoreValidator.validate(user.getState().getThirdSubjectResult());
	}

}
