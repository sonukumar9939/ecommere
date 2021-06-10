package com.user.core.userManagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.user.core.userManagement.enums.Gender;

import lombok.Data;

@Data
@Entity
@Table(name ="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private Long id;
	
	@Column(name ="name", nullable = false)
	private String name;
	
	@Column(name ="email", nullable = false)
	private String email;
	
	@Column(name ="phone_number", nullable = false, unique = true)
	private Long phoneNumber;
	
	@Column(name="age", nullable = false)
	private Integer age;
	
	@Column(name ="gender", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<UserAddress> addresses = new ArrayList<>();
	
}
