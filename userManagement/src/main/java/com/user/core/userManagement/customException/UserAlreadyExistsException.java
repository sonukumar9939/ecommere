package com.user.core.userManagement.customException;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String key;
	private String value;

	public UserAlreadyExistsException(String key, String value, String msg) {
		super(msg);
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	

}
