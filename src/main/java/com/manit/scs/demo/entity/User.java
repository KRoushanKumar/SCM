package com.manit.scs.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "image_url")
	private String image;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	@Column(name = "year")
	private int year;

	@Column(name = "department")
	private String departmentId;
	

	
	@Transient
	public String getImagePath() {
		if (image == null)
			return null;

		return "img/stuImg/" + id + "/" + image;
	}
	
	public User() {
	}

	public User(String userName, String password, String firstName, String lastName, String email) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(String userName, String password, String firstName, String lastName, String email,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}

	
	
//	public User(String userName, String password, String firstName, String lastName, String email,
//			Collection<Role> roles, int year, int departmentId) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.roles = roles;
//		this.year = year;
//		this.departmentId = departmentId;
//	}
	
	

//	public User(String userName, String password, String firstName, String lastName, String email, String image,
//			Collection<Role> roles, int year, long departmentId) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.image = image;
//		this.roles = roles;
//		this.year = year;
//		this.departmentId = departmentId;
//	}

	
		
	public User(int id, String userName, String password, String firstName, String lastName, String email,
			String image, Collection<Role> roles, int year, String departmentId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
		this.roles = roles;
		this.year = year;
		this.departmentId = departmentId;
	}

	
	public Integer getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String l) {
		this.departmentId = l;
	}
	
	

	public String getImage() {
		return image;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", password='" + "*********" + '\''
				+ ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\''
				+ ", roles=" + roles + '}';
	}

	
}
