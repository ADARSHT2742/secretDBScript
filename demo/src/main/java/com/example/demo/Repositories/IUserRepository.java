package com.example.demo.Repositories;

import java.util.List;

import com.example.demo.Models.User;
import com.example.demo.Models.UserLogin;
import com.example.demo.Models.UserPassword;

public interface IUserRepository {
	public List<User> getUsers();

	public User findUser(int user_id);

	public User findUser(String username);

	public User createUser(User user, UserPassword userpassword);

	public User updateUser(User user);

	public boolean deleteUser(int user_id);

	public boolean authenticateUser(UserLogin userlogin);

	public boolean resetPassword(UserLogin userlogin);

	public boolean checkIfMailIsValid(User user);

	public boolean checkIfContactNumberIsValid(User user);

	public boolean checkIfUserNameIsValid(User user);
}
