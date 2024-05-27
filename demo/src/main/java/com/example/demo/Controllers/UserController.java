package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.User;
import com.example.demo.Repositories.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController { // Renamed from RestController to UserController
	
	@Autowired
	private IUserRepository iur;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		System.out.println("In controller users got");
		return iur.getUsers();
	}
	
	@PostMapping("/create")
	public Map<String,Boolean> createUser(@ModelAttribute User u) {
		System.out.println("In controller user created");
		Map<String,Boolean> userResult = new HashMap<>();
		userResult.put("OperationStatus", iur.createUser(u));
		return userResult;
	}
	
	@PutMapping("/update")
	public Map<String,Boolean> updateUser(@ModelAttribute User u) {
		System.out.println("In controller user updated");
		Map<String,Boolean> userResult = new HashMap<>();
		userResult.put("OperationStatus", iur.updateUser(u));
		return userResult;
	}
	
	@PutMapping("/delete")
	public Map<String,Boolean> deleteUser(@ModelAttribute User u) {
		System.out.println("In controller user deleted");
		Map<String,Boolean> userResult = new HashMap<>();
		userResult.put("OperationStatus", iur.deleteUser(u));
		return userResult;
	}
}
