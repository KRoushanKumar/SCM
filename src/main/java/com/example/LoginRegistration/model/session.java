package com.example.LoginRegistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ses_id;
	
	private String start_year;
	private String end_year;
	
	private char status;
	
	

	
	public session(String start_year, String end_year, char status) {
		super();
		this.start_year = start_year;
		this.end_year = end_year;
		this.status = status;
	}
	public long getSes_id() {
		return ses_id;
	}

	public void setSes_id(long ses_id) {
		this.ses_id = ses_id;
	}

	public String getStart_year() {
		return start_year;
	}

	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}

	public String getEnd_year() {
		return end_year;
	}

	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
