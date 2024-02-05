package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="electric")
public class Electric {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="days_num")
	private int daysNum;
	
	@Column(name="prorated_factor")
	private double proratedFactor;
	
	@Column(name="consumption_kwh")
	private double consumptionKWH;
	
	@Column(name="consumption_rm")
	private double consumptionRM;
	
	@Column(name="month")
	private String month;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDaysNum() {
		return daysNum;
	}

	public void setDaysNum(int daysNum) {
		this.daysNum = daysNum;
	}

	public double getProratedFactor() {
		return proratedFactor;
	}

	public void setProratedFactor(double proratedFactor) {
		this.proratedFactor = proratedFactor;
	}

	public double getConsumptionKWH() {
		return consumptionKWH;
	}

	public void setConsumptionKWH(double consumptionKWH) {
		this.consumptionKWH = consumptionKWH;
	}

	public double getConsumptionRM() {
		return consumptionRM;
	}

	public void setConsumptionRM(double consumptionRM) {
		this.consumptionRM = consumptionRM;
	}
    
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setUser(User user) {
        this.user = user;
    }

	public User getUser() {
		return user;
	}

    
	
}