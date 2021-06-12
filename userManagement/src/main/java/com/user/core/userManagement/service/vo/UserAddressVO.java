package com.user.core.userManagement.service.vo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserAddressVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String locality;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String state;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String city;

	@NotNull(message = "{notnull.field.validation.error}")
	private Long pinCode;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String country;

}
