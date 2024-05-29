package com.Controllers;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Database_logic_layer.userContract;
import com.Models.LoginUser;
import com.Models.Student;
import com.Models.User;
import com.Models.UserPassword;

@Controller
public class AuthController {

	@Autowired
	private userContract udb;

	@Autowired
	private EntityManager em;

	@Autowired
	private Logger logger;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		logger.trace("This is a TRACE message");
		logger.debug("This is a DEBUG message");
		logger.info("This is an INFO message");
		logger.warn("This is a WARN message");
		logger.error("This is an ERROR message");
		logger.fatal("This is a FATAL message");

		// Check if DEBUG level is enabled
		System.out.println("DEBUG level is enabled: " + logger.isDebugEnabled());

		// Check if TRACE level is enabled
		System.out.println("TRACE level is enabled: " + logger.isTraceEnabled());

		// Check if INFO level is enabled
		System.out.println("INFO level is enabled: " + logger.isInfoEnabled());

		// Check if WARN level is enabled
		System.out.println("WARN level is enabled: " + logger.isWarnEnabled());

		// Check if ERROR level is enabled
		System.out.println("ERROR level is enabled: " + logger.isErrorEnabled());

		// Check if FATAL level is enabled
		System.out.println("FATAL level is enabled: " + logger.isFatalEnabled());

		return "home";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage(@ModelAttribute LoginUser user) {
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@ModelAttribute LoginUser user, HttpSession hs) {
		System.out.println(user.toString());
		boolean status = udb.authenticateUser(user);
		if (status) {
			System.out.println("valid credentials");
			hs.setAttribute("login_status", true);
			return "redirect:welcome";
		} else {
			System.out.println("Invalid Credentials");
			return "redirect:";
		}
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpPage(@ModelAttribute User user, UserPassword userpass) {
		System.out.println(user.toString());
		System.out.println(userpass.toString());
		int user_id = udb.createUser(user, userpass);
		if (user_id == 0) {
			return "redirect:";
		} else {
			System.out.println("User created with user id= : " + user_id);
			return "redirect:welcome";
		}
	}

	@RequestMapping(value = "/forgotPass", method = RequestMethod.GET)
	public String passwordResetPage() {
		return "fgpassword";
	}

	@RequestMapping(value = "/reset_password", method = RequestMethod.POST)
	public String resetPassword() {
		return "fgpassword";
	}

	@RequestMapping(value = "/checkorm", method = RequestMethod.POST)
	public String checkORM() {
		Student s = new Student(1, "asdf", "asdf");
		em.persist(s);
		return "fgpassword";
	}
}
