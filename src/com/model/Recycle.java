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
	

}