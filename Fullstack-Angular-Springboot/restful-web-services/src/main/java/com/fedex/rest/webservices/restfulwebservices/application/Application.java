package com.fedex.rest.webservices.restfulwebservices.application;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String EAI;

	private Date targetDate;
	private boolean isDone;
	
	protected Application() {
		
	}
	
	public Application(long id, String username, String EAI, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.EAI = EAI;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEAI() {
		return EAI;
	}

	public void setEAI(String eAI) {
		EAI = eAI;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
