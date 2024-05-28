package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Models.User;
import com.example.demo.Repositories.IUserRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class RestController {

	@Autowired
	private IUserRepository iur;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<User> getUsers() {
		System.out.println("Fetching all users...");
		List<User> users = iur.getUsers();
		return users;
	}

	@RequestMapping(value = "/update/{user_id}", method = RequestMethod.GET)
	public Map<String, String> updateUser(@RequestBody User user, @PathVariable int user_id) {
		System.out.println("Updating user with ID: " + user_id);
		Map<String, String> userResult = new HashMap<>();
		userResult.put("user message ", "success");
		return userResult;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Map<String, String> deleteUser(@PathVariable int id) {
		Map<String, String> userResult = new HashMap<>();
		userResult.put("user message ", "success");
		return userResult;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public List<User> createUser(@RequestBody User user) {
		List<User> users = new ArrayList<>();
		System.out.println("Creating new user...");
		return users;
	}
}
