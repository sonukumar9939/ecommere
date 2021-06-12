package com.user.core.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.core.userManagement.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
