package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recycle")
public class Recycle {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="weight_kg")
	private int weightKg;
	
	@Column(name="weight_rm")
	private int weightRm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(int weightKg) {
		this.weightKg = weightKg;
	}

	public int getWeightRm() {
		return weightRm;
	}

	public void setWeightRm(int weightRm) {
		this.weightRm = weightRm;
	}
	

}