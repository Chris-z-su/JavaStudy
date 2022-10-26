package com.sxt.service;

import com.sxt.pojo.User;

public interface UserService {
	/**
	 * ÓÃ»§µÇÂ¼
	 * @param user
	 * @return
	 */
	public User login(String uname, String pwd);
}
