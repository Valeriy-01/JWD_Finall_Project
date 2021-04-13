package by.tc.applicant.validator.impl;

import by.tc.applicant.bean.User;
import by.tc.applicant.validator.Validator;

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
		if (user == null) {
			return false;
		}
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
