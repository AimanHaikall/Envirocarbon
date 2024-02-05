package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recycle")
public class Recycle {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="weight_kg")
	private double weightKg;
	
	@Column(name="weight_rm")
	private double weightRm;
	
	@Column(name="month")
	private String month;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(double weightKg2) {
		this.weightKg = weightKg2;
	}

	public double getWeightRm() {
		return weightRm;
	}

	public void setWeightRm(double weightRm2) {
		this.weightRm = weightRm2;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
	

}