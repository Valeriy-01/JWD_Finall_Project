package by.tc.applicant.validator.exception;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException(Exception e) {
		super(e);
	}

	public ValidatorException(String message, Exception e) {
		super(message, e);
	}
}
