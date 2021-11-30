package com.wipro.votingsystem.entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
@Table(name="citizens")
@Entity


public class Citizen {
    
	@Id
	@Column(name="id")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="hasvoted")
	private boolean hasvoted;
	
	public boolean getHasVoted() {
		return hasvoted;
	}

	public void setHasVoted(boolean hasvoted) {
		this.hasvoted = hasvoted;
	}

	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citizen(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
