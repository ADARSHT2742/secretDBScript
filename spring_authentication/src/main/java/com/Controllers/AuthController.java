package com.Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Models.LoginUser;
import com.Models.Student;
import com.Models.User;
import com.Models.UserPassword;
import com.Repositories.userContract;

@Controller
public class AuthController {

	@Autowired
	private userContract udb;

	@Autowired
	private EntityManager em;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
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
	
	
	@RequestMapping(value = "/checkorm", method = RequestMethod.GET)
	@Transactional
	public String checkORM() {
		Student s = new Student();
		s.setClassname("sas");
		s.setName("\"asdf\", \"asdf\"");
	 EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            em.persist(s);
            System.out.println(s.toString());
            System.out.println("I have added the student to db");

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
		System.out.println("I have added the student to db");
		return "fgpassword";
	}
}
