package com.example.demo.Repositories;

import java.util.List;

import com.example.demo.Models.User;

public interface IUserRepository {
	public List<User> getUsers();
	public boolean updateUser(User u);
	public boolean deleteUser(User u);
	public boolean createUser(User u);
	
	public User getUser(User u);
	public boolean authenticateUser(User u);
}