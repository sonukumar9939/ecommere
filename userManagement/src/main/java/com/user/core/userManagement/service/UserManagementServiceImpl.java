package com.user.core.userManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.core.userManagement.customException.UserAlreadyExistsException;
import com.user.core.userManagement.model.User;
import com.user.core.userManagement.model.UserAddress;
import com.user.core.userManagement.repository.UserAddressRepository;
import com.user.core.userManagement.repository.UserManagementRepository;
import com.user.core.userManagement.service.vo.UserAddressVO;
import com.user.core.userManagement.service.vo.UserVO;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);

	@Autowired
	private UserManagementRepository userManagementRepository;
	
	@Autowired
	private UserAddressRepository  userAddressRepository;

	@Override
	public void validate(UserVO userVO) {

		Optional<User> userOptional = userManagementRepository.findByNameIgnoreCaseAndPhoneNumber(userVO.getName(),userVO.getPhoneNumber());
		if (userOptional.isPresent()) {
			throw new UserAlreadyExistsException("name", "", "User with name " + userVO.getName() + " and phoneNumber "
					+ userVO.getPhoneNumber() + " already exists ::::");
		}
	}

	@Override
	@Transactional
	public void save(UserVO userVO) {
		Long userId = createUser(userVO);
		if(userVO.getAddresses()!=null && !userVO.getAddresses().isEmpty()) {
			createUserAddresses(userVO.getAddresses(),userId);
		}
	}
	
	private void createUserAddresses(List<UserAddressVO> addresses, Long userId) {
		List<UserAddress> userAddressList = new ArrayList<>();
		addresses.forEach(address->{
			UserAddress userAddress = new UserAddress();
			userAddress.setCity(address.getCity());
			userAddress.setCountry(address.getCountry());
			userAddress.setLocality(address.getLocality());
			userAddress.setPinCode(address.getPinCode());
			userAddress.setState(address.getState());
			userAddress.setUserId(userId);
			userAddressList.add(userAddress);
		});
		userAddressRepository.saveAll(userAddressList);
	}

	private Long createUser(UserVO userVO) {
		User userEntity = new User();
		userEntity.setName(userVO.getName());
		userEntity.setPhoneNumber(userVO.getPhoneNumber());
		userEntity.setAge(userVO.getAge());
		userEntity.setGender(userVO.getGender());
		userEntity.setEmail(userVO.getEmail());
		return userManagementRepository.save(userEntity).getId();
	}

}
