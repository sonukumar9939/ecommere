package com.user.core.userManagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private Long id;
	
	@Column(name="user_id", nullable = false)
	private Long userId;

	@Column(name ="locality", nullable = false)
	private String locality;

	@Column(name ="state", nullable = false)
	private String state;

	@Column(name ="city", nullable = false)
	private String city;

	@Column(name ="pin_code", nullable = false)
	private Long pinCode;

	@Column(name ="country", nullable = false)
	private String country;
}
