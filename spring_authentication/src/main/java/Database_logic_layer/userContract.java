package Database_logic_layer;

import Models.LoginUser;

public interface userContract {
	public boolean authenticateUser(LoginUser user);
}
