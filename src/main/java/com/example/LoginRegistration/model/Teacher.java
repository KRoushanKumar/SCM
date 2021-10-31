package com.example.LoginRegistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")

public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long t_id;
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name ="middle_name")
	private String middleName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name = "email") 
	private String email;
	
	@Column(name = "depatment") 
	private int depatment;
	
	
	
	@Column(name = "status") 
	private String status;

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDepatment() {
		return depatment;
	}

	public void setDepatment(int depatment) {
		this.depatment = depatment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Teacher(String firstName, String middleName, String lastName, String email, int depatment, String status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.depatment = depatment;
		this.status = status;
	}
	
	
	
}
