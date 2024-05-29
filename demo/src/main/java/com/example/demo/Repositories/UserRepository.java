package com.example.demo.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.User;
import com.example.demo.Models.UserLogin;
import com.example.demo.Models.UserPassword;
import com.example.demo.Utilities.StringFormatter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

	@Autowired
	private EntityManager em;

	@Autowired
	private StringFormatter stringFormatter;

	public List<User> getUsers() {
		TypedQuery<User> tqu = em.createQuery("select u from User u", User.class);
		List<User> usersList = tqu.getResultList();
		return usersList;
	}

	public User findUser(int user_id) {
		User temp = em.find(User.class, user_id);
		System.out.println(temp.toString());
		return temp;
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

	public boolean checkIfMailIsValid(User user) {
		try {
			TypedQuery<Long> tqu = em.createQuery("select count(u) from User u where mail = :givenusermail",
					Long.class);
			tqu.setParameter("givenusermail", user.getMail());
			long count = tqu.getSingleResult();
			System.out.println("Required count : " + count);
			return count == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkIfContactNumberIsValid(User user) {
		try {
			TypedQuery<Long> tqu = em.createQuery("select count(u) from User u where usercontact = :givenusercontact",
					Long.class);
			tqu.setParameter("givenusercontact", user.getUsercontact());
			long count = tqu.getSingleResult();
			System.out.println("Required count : " + count);
			return count == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkIfUserNameIsValid(User user) {
		try {
			TypedQuery<Long> tqu = em.createQuery("select count(u) from User u where username = :givenusername",
					Long.class);
			tqu.setParameter("givenusername", user.getUsername());
			long count = tqu.getSingleResult();
			System.out.println("Required count : " + count);
			return count == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User createUser(User user, UserPassword userpassword) {
		try {
			em.persist(user);
			String encrypted_pwd = stringFormatter.encrypt(userpassword.getPassword());
			System.out.println("Encryped Password : " + encrypted_pwd);
			userpassword.setPassword(encrypted_pwd);
			// encrypt the user password : password field
			userpassword.setUser(user);
			em.persist(userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	public User updateUser(User user) {
		User temp = em.merge(user);
		System.out.println(temp.toString());
		return temp;
	}

	public boolean deleteUser(int user_id) {
		try {
			User temp = this.findUser(user_id);
			if (temp != null)
				em.remove(temp);
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
		// decrypt the user password field
		String decrypt_pwd = "";
		try {
			decrypt_pwd = stringFormatter.decrypt(userpassword.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Decryped Password : " + decrypt_pwd);
		if (decrypt_pwd.equals(userlogin.getUserpassword())) {
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
		try {
			UserPassword userpassword = user.getUserPassword();
			// encrypt the user password
			String encrypted_pwd = stringFormatter.encrypt(userlogin.getUserpassword());
			userpassword.setPassword(encrypted_pwd);
			em.merge(userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
