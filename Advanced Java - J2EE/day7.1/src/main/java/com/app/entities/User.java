package com.app.entities;
//users table  

//column - id , first name , last name, email ,password , dob , phone no , role

import java.time.LocalDate;  
import javax.persistence.*;

@Entity //to tell hibernate following class is an entity , 
//whose life cycle is to be managed by Hibernate
@Table(name="users")//to specify table name
public class User {
	@Id //=> PK constraint , ids must be supplied !
	//for auto id generation
	@GeneratedValue(strategy = GenerationType.IDENTITY) //hib chooses the def. strategy - 
	//AUTO => using hibernate_sequence table
	/*
	 * GenerationType.IDENTITY : most suitable for MySQL DB , to support auto increment.
	 */	
	private Long id;//must be Serializable .
	@Column(name="first_name",length = 20)//col name n varchar(20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 30,unique = true)//unique constraint
	private String email;
	@Column(length = 20,nullable = false)//NOT NULL 
	private String password;
	private LocalDate dob;//col type : date
	@Column(name="phone_no",length =14,unique = true)
	private String phoneNo;
	@Enumerated(EnumType.STRING) //for the enum - 
	//by def hib stores ordinals (int) , to replace it by constant names
	@Column(length = 20)
	private Role role;
	@Lob //large object with byte[] -col type : longblob
	private byte[] image;
	@Column(name="reg_amount") //not null 
	private double regAmount;

	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(String firstName, String lastName, String email, String password, LocalDate dob, String phoneNo,
			Role role, double regAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.role = role;
		this.regAmount = regAmount;
	}
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}



	// all getters n setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", phoneNo=" + phoneNo + ", role=" + role + "]";
	}

}
