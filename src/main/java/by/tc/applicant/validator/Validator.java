package by.tc.applicant.validator;

import by.tc.applicant.validator.exception.ValidatorException;

public interface Validator<T> {
	Boolean validate(T t) throws ValidatorException;
}
