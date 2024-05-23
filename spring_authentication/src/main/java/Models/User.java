package Models;

import org.springframework.stereotype.Service;

@Service
public class User {
	private int userid;
	private String username;
	private String fullname;
	private String usermail;
	private long usercontactnumber;

	public User() {
	}

	public User(int userid, String username, String fullname, String usermail, long usercontactnumber) {
		super();
		this.userid = userid;
		this.username = username;
		this.fullname = fullname;
		this.usermail = usermail;
		this.usercontactnumber = usercontactnumber;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public long getUsercontactnumber() {
		return usercontactnumber;
	}

	public void setUsercontactnumber(long usercontactnumber) {
		this.usercontactnumber = usercontactnumber;
	}

}
