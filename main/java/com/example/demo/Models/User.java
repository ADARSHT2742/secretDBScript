package com.example.demo.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "springbootusers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String fullname;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String mail;

	@Column(unique = true, nullable = false)
	private Long usercontact;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserPassword up;

	public User(Integer id, String fullname, String username, String mail, Long usercontact) {
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.mail = mail;
		this.usercontact = usercontact;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(Long usercontact) {
		this.usercontact = usercontact;
	}

	public UserPassword getUserPassword() {
		return up;
	}

	public void setUserPassword(UserPassword up) {
		this.up = up;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", username=" + username + ", mail=" + mail
				+ ", usercontact=" + usercontact + "]";
	}
}
