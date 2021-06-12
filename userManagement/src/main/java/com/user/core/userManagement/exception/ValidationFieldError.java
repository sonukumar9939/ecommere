package com.user.core.userManagement.exception;

public class ValidationFieldError {

	private String field;
	private String code;
	private String message;
	
	public ValidationFieldError(String field, String code, String message) {
		super();
		this.field = field;
		this.code = code;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
