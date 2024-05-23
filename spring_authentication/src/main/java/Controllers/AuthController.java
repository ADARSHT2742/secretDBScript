package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Database_logic_layer.userContract;
import Models.LoginUser;

@Controller
public class AuthController {

	@Autowired
	private userContract udb;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@ModelAttribute LoginUser user) {
		System.out.println(user.getUsername());
		System.out.println(user.getUserpwd());
		if (udb.authenticateUser(user)) {
			System.out.println("valid credentials");
			return "home";
		} else {
			System.out.println("Invalid Credentials");
			return "redirect:";
		}
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpPage() {
		return "home";
	}

	@RequestMapping(value = "/forgotPass", method = RequestMethod.POST)
	public String passwordResetPage() {
		return "fgpassword";
	}

	@RequestMapping(value = "/reset_password", method = RequestMethod.GET)
	public String resetPassword() {
		return "fgpassword";
	}
}
