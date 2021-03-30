package by.tc.finalproject.validator;

import by.tc.finalproject.validator.exception.ValidatorException;

public interface Validator<T> {
	Boolean validate(T t) throws ValidatorException;
}
