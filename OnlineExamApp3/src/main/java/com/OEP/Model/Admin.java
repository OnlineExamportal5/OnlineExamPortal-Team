package com.OEP.Model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	private int id;

	@Column(name = "name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "user name must have atleast two character")
	private String name;

	@NotNull(message = "email filed must not be empty")
	@Email(message = "email should be in valid format")
	private String email;

	@Column(name = "password", nullable = false)
	@NotEmpty
	@Size(min = 6, message = "user password must have atleast six character")
	private String password;

	@NotEmpty
	@Size(max = 10, message = "address name should be between 1 to 10 character.. ")
	private String address;
	
	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + "]";
	}

//	 @Id
//	 private int id;
//	 private String name;
//	 private String address;
//	 private String email;
//	 private String password;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	@Override
//	public String toString() {
//		return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
//				+ password + "]";
//	}
//	

}
