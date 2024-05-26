package com.Repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.Models.LoginUser;
import com.Models.User;
import com.Models.UserPassword;

@Repository
public class UserDB implements userContract {
	@Autowired
	private JdbcTemplate plpgsql_ptr;

	public void setPtr(JdbcTemplate ptr) {
		this.plpgsql_ptr = ptr;
	}

	public boolean authenticateUser(LoginUser user) {
		int user_count = 0;
		try {
			int user_id = plpgsql_ptr.queryForObject("select userid from applnsusers where username=?",
					new Object[] { user.getUsername() }, Integer.class);
			System.out.println("User id is : " + user_id);
			user_count = plpgsql_ptr.queryForObject("select count(*) from applnsuserpwds where userid=? and userpwd =?",
					new Object[] { user_id, user.getUserpwd() }, Integer.class);
		} catch (Exception e) {
			System.out.println("Exception Occured");
		}
		return user_count == 1;
	}

	public int createUser(User user, UserPassword userpass) {
		int final_user_id = 0;
		try {
			plpgsql_ptr.execute(
					"insert into applnsusers(username,fullname,usermail,usercontactnumber) values(?,?,?,?);",
					new PreparedStatementCallback<Integer>() {

						public Integer doInPreparedStatement(PreparedStatement ps)
								throws SQLException, DataAccessException {
							ps.setString(1, user.getUsername());
							ps.setString(2, user.getFullname());
							ps.setString(3, user.getUsermail());
							ps.setLong(4, user.getUsercontactnumber());

							// insert into applns users
							ps.executeUpdate();

							return 1;
						}
					});

			int user_id = plpgsql_ptr.queryForObject("select userid from applnsusers where username =? ",
					new Object[] { user.getUsername() }, Integer.class);

			plpgsql_ptr.execute("insert into applnsuserpwds(userid,userpwd) values(?,?); ",
					new PreparedStatementCallback<Integer>() {
						@Override
						public Integer doInPreparedStatement(PreparedStatement ps)
								throws SQLException, DataAccessException {
							ps.setInt(1, user_id);
							ps.setString(2, userpass.getUserpwd());
							ps.executeUpdate();
							return 1;
						}
					});

			final_user_id = user_id;

		} catch (Exception e) {
			System.out.println("An Exception occured");
		}
		return final_user_id;
	}
}
