package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="water")
public class Water {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="days_num")
	private int daysNum;
	
	@Column(name="prorated_factor")
	private double proratedFactor;
	
	@Column(name="consumption_m3")
	private double consumptionM3;
	
	@Column(name="consumption_rm")
	private double consumptionRM;
	
	
}
