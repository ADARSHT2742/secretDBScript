package com.example.demo.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Models.User;

public class UserRepository implements IUserRepository {

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		System.out.println("Obtained Users");
		return users;
	}

	@Override
	public boolean updateUser(User u) {
		System.out.println("Updated user");
		return true;
	}

	@Override
	public boolean deleteUser(User u) {
		System.out.println("Deleted user");
		return true;
	}

	@Override
	public boolean createUser(User u) {
		System.out.println("Created User");
		return true;
	}

	@Override
	public User getUser(User u) {
		System.out.println("User got");
		User us = new User();
		return us;
	}

	@Override
	public boolean authenticateUser(User u) {
		System.out.println("User authenticated");
		return true;
	}
	
}
