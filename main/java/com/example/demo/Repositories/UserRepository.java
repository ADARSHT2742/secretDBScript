package com.example.demo.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.User;
import com.example.demo.Models.UserLogin;
import com.example.demo.Models.UserPassword;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

	@Autowired
	private EntityManager em;

	public List<User> getUsers() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	public User findUser(int user_id) {
		return em.find(User.class, user_id);
	}

	public User findUser(String username) {
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username";
			return em.createQuery(jpql, User.class).setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User createUser(User user, UserPassword userpassword) {
		try {
			em.persist(user);
			userpassword.setUser(user);
			em.persist(userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	public User updateUser(User user) {
		return em.merge(user);
	}

	public boolean deleteUser(int user_id) {
		try {
			em.remove(this.findUser(user_id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean authenticateUser(UserLogin userlogin) {
		System.out.println(userlogin.toString());
		User user = this.findUser(userlogin.getUsername());
		if (user == null) {
			return false;
		}
		UserPassword userpassword = user.getUserPassword();
		System.out.println(user.toString());
		System.out.println(userpassword.toString());
		if (userpassword.getPassword().equals(userlogin.getUserpassword())) {
			return true;
		}
		return false;
	}

	public boolean resetPassword(UserLogin userlogin) {
		System.out.println(userlogin.toString());
		User user = this.findUser(userlogin.getUsername());
		if (user == null) {
			return false;
		}
		UserPassword userpassword = user.getUserPassword();
		userpassword.setPassword(userlogin.getUserpassword());
		try {
			em.merge(userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
