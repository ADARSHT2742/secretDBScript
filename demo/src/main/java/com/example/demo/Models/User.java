package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private Long contact;
	private String mail;
	private String username;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private UserPassword userPassword;
	
	public User(Integer id, String name, Long contact, String mail, String username) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.mail = mail;
		this.username = username;
	}
	

	public User() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getContact() {
		return contact;
	}


	public void setContact(Long contact) {
		this.contact = contact;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
}
