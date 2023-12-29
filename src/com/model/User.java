package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneNum")
	private String phoneNum;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status_application")
	private String statusApplication;
	
	@Column(name="institution")
	private String institution;
	
	@Column(name="category")
	private String category;
	
	@Column(name="housholdNum")
	private String householdNum;
	
}
