package com.example.demo.Models;

import java.util.Objects;

public class UserSignUp {
	private String fullname;
	private String username;
	private String usermail;
	private Long usercontactnumber;
	private String password;

	public UserSignUp(String username, String usermail, String fullname, Long usercontactnumber, String password) {
		super();
		this.username = username;
		this.usermail = usermail;
		this.fullname = fullname;
		this.usercontactnumber = usercontactnumber;
		this.password = password;
	}

	public UserSignUp() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Long getUsercontactnumber() {
		return usercontactnumber;
	}

	public void setUsercontactnumber(Long usercontactnumber) {
		this.usercontactnumber = usercontactnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserSignUp [username=" + username + ", usermail=" + usermail + ", fullname=" + fullname
				+ ", usercontactnumber=" + usercontactnumber + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(usercontactnumber, fullname, password, usermail, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSignUp other = (UserSignUp) obj;
		return Objects.equals(usercontactnumber, other.usercontactnumber) && Objects.equals(fullname, other.fullname)
				&& Objects.equals(password, other.password) && Objects.equals(usermail, other.usermail)
				&& Objects.equals(username, other.username);
	}
}
