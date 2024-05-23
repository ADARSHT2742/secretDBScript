package Database_logic_layer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Models.LoginUser;

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
}
