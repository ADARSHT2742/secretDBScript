package com.example.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Models.User;
import com.example.demo.Models.UserLogin;
import com.example.demo.Models.UserPassword;
import com.example.demo.Models.UserSignUp;
import com.example.demo.Repositories.IUserRepository;

@Controller
public class HomeController {

	@Autowired
	private IUserRepository iur;

	private static final Logger logptr = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logptr.trace("Trace message from home page invocation");
		logptr.debug("Debug message from home page invocation");
		logptr.info("Info message from home page invocation");
		logptr.warn("Warn message from home page invocation");
		logptr.error("Error message from home page invocation");
		return "home";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage() {
		return "welcomePage";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgotPasswordPage() {
		return "fgpassword";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticateUser(UserLogin userlogin) {
		System.out.println(userlogin.toString());
		if (iur.authenticateUser(userlogin)) {
			return "redirect:welcome";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpUser(UserSignUp usersignup) {
		// do with user and userpassword only
		System.out.println("User sign up invoked");

		User user = new User();
		user.setFullname(usersignup.getFullname());
		user.setUsername(usersignup.getUsername());
		user.setMail(usersignup.getUsermail());
		user.setUsercontact(usersignup.getUsercontactnumber());

		UserPassword userpassword = new UserPassword();
		userpassword.setPassword(usersignup.getPassword());

		System.out.println(user.toString());
		System.out.println(userpassword.toString());

		User u = iur.createUser(user, userpassword);
		if (u == null) {
			System.out.println("User not created");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String resetPassword(UserLogin userlogin) {
		if (iur.resetPassword(userlogin)) {
			System.out.println("Successful reset of user password");
			return "redirect:/";
		}
		System.out.println("Failed to reset user password");
		return "fgpassword";
	}
}
