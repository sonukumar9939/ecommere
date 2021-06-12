package com.user.core.userManagement.exception;

public enum ValidationErrorCode {

	NotNull("notempty.validation.error"),
	NotEmpty("notempty.validation.error");

	private String errorCode;

	private ValidationErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
