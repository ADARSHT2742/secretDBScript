package com.Models;

import org.springframework.stereotype.Service;

@Service
public class LoginUser {
	private String username;
	private String userpwd;

	public LoginUser() {
	}

	public LoginUser(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", userpwd=" + userpwd + "]";
	}

}
