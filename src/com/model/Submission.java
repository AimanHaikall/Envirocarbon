package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submission")
public class Submission {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "resultWater")
	private double resultWater;

	@Column(name = "resultElectric")
	private double resultElectric;

	@Column(name = "resultRecycle")
	private double resultRecycle;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public User getUser() {
		return user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getResultWater() {
		return resultWater;
	}

	public void setResultWater(double resultWater) {
		this.resultWater = resultWater;
	}

	public double getResultElectric() {
		return resultElectric;
	}

	public void setResultElectric(double resultElectric) {
		this.resultElectric = resultElectric;
	}

	public double getResultRecycle() {
		return resultRecycle;
	}

	public void setResultRecycle(double resultRecycle) {
		this.resultRecycle = resultRecycle;
	}

	public double calculateTotalResult() {
		return getResultWater() + getResultElectric() + getResultRecycle();
	}

}
