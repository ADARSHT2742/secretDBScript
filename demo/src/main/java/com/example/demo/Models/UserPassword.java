package com.example.demo.Models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "springbootuserpasswords")
public class UserPassword {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 1000)
	private String password;

	@OneToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;

	public UserPassword(Integer id, String password, User user) {
		super();
		this.id = id;
		this.password = password;
		this.user = user;
	}

	public UserPassword() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPassword [id=" + id + ", password=" + password + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPassword other = (UserPassword) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(user, other.user);
	}

}
