package com.UserManager;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class UsersManager {
	private static List<Users> userList;

	static {
		Users u1 = new Users();
		u1.setUserID(01);
		u1.setIsAuthenticated(false);
		u1.setUserName("User-1");
		u1.setUserPass("123");

		Users u2 = new Users();
		u2.setUserID(02);
		u2.setIsAuthenticated(false);
		u2.setUserName("User-2");
		u2.setUserPass("abc");

		Users u3 = new Users();
		u3.setUserID(03);
		u3.setIsAuthenticated(false);
		u3.setUserName("User-3");
		u3.setUserPass("xyz");

		Users u4 = new Users();
		u4.setUserID(04);
		u4.setIsAuthenticated(false);
		u4.setUserName("User-4");
		u4.setUserPass("987");

		userList = new LinkedList<Users>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
	}

	public List<Users> getUserList() {
		return userList;
	}

	public Users getuserid(List<Users> u, int id) {
		for (int i = 0; i < u.size(); i++) {
			Users u1 = u.get(i);
			if (u1.getUserID() == id) {
				return u1;
			}
		}
		return null;
	}

	public List<Users> edituserid(List<Users> u, Users user) {
		for (int i = 0; i < u.size(); i++) {
			Users u1 = u.get(i);
			if (u1.getUserID() == user.getUserID()) {
				u1.setUserName(user.getUserName());
				u1.setUserPass(user.getUserPass());
				u1.setIsAuthenticated(user.getIsAuthenticated());
			}
		}
		return u;

	}

}
