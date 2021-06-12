package com.user.core.userManagement.service.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.user.core.userManagement.enums.Gender;

import lombok.Data;

@Data
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String name;

	@NotEmpty(message = "{notempty.field.validation.error}")
	private String email;

	@NotNull(message = "{notnull.field.validation.error}")
	private Long phoneNumber;

	@NotNull(message = "{notnull.field.validation.error}")
	private Integer age;

	@NotNull(message = "{notnull.field.validation.error}")
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	@Valid
	@NotEmpty(message = "{notempty.field.validation.error}")
	private List<UserAddressVO> addresses = new ArrayList<>();

}
