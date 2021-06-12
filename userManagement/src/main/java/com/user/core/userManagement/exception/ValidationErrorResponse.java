package com.user.core.userManagement.exception;

import java.util.List;

public class ValidationErrorResponse {

	private String code;
	private String message;
	private List<ValidationFieldError> validationFieldErrors;

	public ValidationErrorResponse(String code, String message, List<ValidationFieldError> validationFieldErrors) {
		super();
		this.code = code;
		this.message = message;
		this.validationFieldErrors = validationFieldErrors;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public List<ValidationFieldError> getValidationFieldErrors() {
		return validationFieldErrors;
	}

}
