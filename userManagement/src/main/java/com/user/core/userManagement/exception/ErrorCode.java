package com.user.core.userManagement.exception;

public enum ErrorCode {

	VALIDATION_ERROR("validation.error"), 
	USER_ALREADY_EXISTS("user.already.exists");

	private String code;

	private ErrorCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
