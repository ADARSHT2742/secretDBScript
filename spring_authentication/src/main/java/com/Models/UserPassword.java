package com.Models;

import org.springframework.stereotype.Service;

@Service
public class UserPassword {
	private int userid;
	private String userpwd;

	public UserPassword() {
	}

	public UserPassword(int userid, String userpwd) {
		this.userid = userid;
		this.userpwd = userpwd;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "UserPassword [userid=" + userid + ", userpwd=" + userpwd + "]";
	}

}
