package com.example.demo.Models;

import java.util.Objects;

public class UserLogin {
	private String username;
	private String userpassword;

	public UserLogin(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}

	public UserLogin() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", userpassword=" + userpassword + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, userpassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(username, other.username) && Objects.equals(userpassword, other.userpassword);
	}

}
