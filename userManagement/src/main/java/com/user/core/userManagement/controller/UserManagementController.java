package com.user.core.userManagement.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.core.userManagement.service.UserManagementService;
import com.user.core.userManagement.service.vo.UserVO;

@RestController
@Validated
@RequestMapping(value = "/api/user")
public class UserManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	private UserManagementService userManagementService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Object> saveUserDetails(@Valid @RequestBody UserVO userVO){
		logger.info("::::::::::  User save process initiated ::::::::::::");
		userManagementService.validate(userVO);
		userManagementService.save(userVO);
		return null;
		
	}

}
