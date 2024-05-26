package com.Repositories;

import com.Models.LoginUser;
import com.Models.User;
import com.Models.UserPassword;

public interface userContract {
	public boolean authenticateUser(LoginUser user);

	public int createUser(User user, UserPassword userpass);
}
