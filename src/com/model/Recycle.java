package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Date month;
	
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

	public void setWeightKg(int weightKg) {
		this.weightKg = weightKg;
	}

	public double getWeightRm() {
		return weightRm;
	}

	public void setWeightRm(int weightRm) {
		this.weightRm = weightRm;
	}
	
	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}
	

}