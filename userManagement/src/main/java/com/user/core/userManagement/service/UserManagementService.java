package com.user.core.userManagement.service;

import com.user.core.userManagement.service.vo.UserVO;

public interface UserManagementService {

	void validate(UserVO userVO);

	void save(UserVO userVO);

}
