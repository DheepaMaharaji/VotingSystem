package com.wipro.votingsystem.entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

@Table(name="candidates")
@Entity
public class Candidate {

	@Id
	@Column(name="id")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name="candidate_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="numberOfVotes")
	private Integer numberOfVotes;
	

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public Candidate(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
