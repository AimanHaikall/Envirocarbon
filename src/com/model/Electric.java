package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name="consumption_m3")
	private double consumptionM3;
	
	@Column(name="consumption_rm")
	private double consumptionRM;
	
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

	public double getConsumptionM3() {
		return consumptionM3;
	}

	public void setConsumptionM3(double consumptionM3) {
		this.consumptionM3 = consumptionM3;
	}

	public double getConsumptionRM() {
		return consumptionRM;
	}

	public void setConsumptionRM(double consumptionRM) {
		this.consumptionRM = consumptionRM;
	}
	
	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}
    
	public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
	
}
