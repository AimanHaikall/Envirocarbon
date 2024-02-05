package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneNum")
	private String phoneNum;
	
	@Column(name="email")
	private String email;
//	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Electric> electricList = new ArrayList<>();
////
//	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval=true)
//	private List<Recycle> recycleList = new ArrayList<>();
//
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Water> waterList = new ArrayList<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public List<Electric> getElectricList() {
//        return electricList;
//    }
//
//    public void setElectricList(List<Electric> electricList) {
//        this.electricList = electricList;
//    }
//
//    public void addElectric(Electric electric) {
//        electric.setUser(this);
//        this.electricList.add(electric);
//    }
//    
//    public List<Recycle> getRecycleList() {
//		return recycleList;
//	}
//
//	public void setRecycleList(List<Recycle> recycleList) {
//		this.recycleList = recycleList;
//	}
//	
//	public List<Water> getWaterList() {
//		return waterList;
//	}
//
//	public void setWaterList(List<Water> waterList) {
//		this.waterList = waterList;
//	}
//	
//	public void addWater(Water water) {
//	    water.setUser(this);
//	    this.waterList.add(water);
//	}
	
}
