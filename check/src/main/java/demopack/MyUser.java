package demopack;

import org.springframework.stereotype.Service;

@Service
public class MyUser {
	private int user_id;
	private String user_pwd;

	public MyUser() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

}
