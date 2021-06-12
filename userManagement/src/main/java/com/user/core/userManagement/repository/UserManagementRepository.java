package com.user.core.userManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.core.userManagement.model.User;

public interface UserManagementRepository extends JpaRepository<User, Long>{

	Optional<User> findByNameIgnoreCaseAndPhoneNumber(String name, Long phoneNumber);

}
