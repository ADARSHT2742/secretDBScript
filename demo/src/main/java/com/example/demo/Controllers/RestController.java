package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Models.User;
import com.example.demo.Models.UserPassword;
import com.example.demo.Models.UserSignUp;
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
		System.out.println("In Controller : " + users.size());
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
	}

	@RequestMapping(value = "/update/{user_id}", method = RequestMethod.POST)
	public Map<String, String> updateUser(@RequestBody User user, @PathVariable int user_id) {
		System.out.println("Updating user with ID: " + user_id);
		user.setId(user_id);
		User u1 = iur.updateUser(user);
		Map<String, String> userResult = new HashMap<>();
		String message = "";
		if (u1 == null) {
			message = "failure";
		} else {
			message = "success";
		}
		userResult.put("user message ", message);
		return userResult;
	}

	@RequestMapping(value = "/delete/{user_id}", method = RequestMethod.GET)
	public Map<String, String> deleteUser(@PathVariable int user_id) {
		boolean status = iur.deleteUser(user_id);
		Map<String, String> userResult = new HashMap<>();
		String message = "";
		if (!status) {
			message = "failure";
		} else {
			message = "success";
		}
		userResult.put("user message ", message);
		return userResult;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Map<String, String> createUser(@RequestBody UserSignUp usersignup) {
		System.out.println("Creating new user...");

		User user = new User();
		user.setFullname(usersignup.getFullname());
		user.setUsername(usersignup.getUsername());
		user.setMail(usersignup.getUsermail());
		user.setUsercontact(usersignup.getUsercontactnumber());

		UserPassword userpassword = new UserPassword();
		userpassword.setPassword(usersignup.getPassword());

		System.out.println(user.toString());

		Map<String, String> userResult = new HashMap<>();

		if (!iur.checkIfMailIsValid(user)) {
			userResult.put("usermessage", "Given mail already exists");
			return userResult;
		}

		if (!iur.checkIfContactNumberIsValid(user)) {
			userResult.put("usermessage", "Given user contact number already exists");
			return userResult;
		}
		if (!iur.checkIfUserNameIsValid(user)) {
			userResult.put("usermessage", "Given user name already exists");
			return userResult;
		}

		User temp = iur.createUser(user, userpassword);
		if (temp == null) {
			userResult.put("usermessage", "Failed to create user, Try again");
			return userResult;
		}

		userResult.put("usermessage", "User Profile created successfully, Login now");
		return userResult;
	}
}
