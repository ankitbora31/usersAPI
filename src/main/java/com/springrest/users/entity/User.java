package com.springrest.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Volunteer")
public class User {
	public User() {};
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long UserId;
	
	private String name;
	
	@Column(unique=true,nullable=false)
	@Email
	private String email;
	
	@Column(unique=true,nullable=false)
	private long phone;
	
	@Column(nullable=false)
    @Size(min=8,message="password should have at least 8 characters")
	private String pass;

	public User(long UserId, String name, String email, long phone, String pass) {
		super();
		this.UserId = UserId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pass=" + pass
				+ "]";
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long UserId) {
		this.UserId = UserId;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
