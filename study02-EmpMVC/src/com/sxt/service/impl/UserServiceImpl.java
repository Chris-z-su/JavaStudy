package com.sxt.service.impl;

import com.sxt.dao.UserDao;
import com.sxt.dao.impl.UserDaoImpl;
import com.sxt.pojo.User;
import com.sxt.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	/**
	 * ÓÃ»§µÇÂ¼
	 */
	@Override
	public User login(String uname, String pwd) {
		return ud.loginDao(uname, pwd);
	}
}
