package com.sxt.service;

import com.sxt.pojo.User;

public interface UserService {
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public User login(String uname, String pwd);
}
