package com.example.LoginRegistration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	@Column(name = "email") 
	private String email;
	
	@Column(name = "image")
	private String image;
	
	
	private String session;
	
	//@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	
	private int department;
	
	private char status;
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	@Transient
	public String getImagePath()
	{
		if(image==null)
			return null;
		
		return "/img/stuImg/"+id+"/"+image;
		//return "/img/stuImg/10/roushan-min.jpeg";
		//return ImagePath;
	}

	public Student()
	{
		
	}
	
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
}