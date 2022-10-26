package com.sxt.dao;

import com.sxt.pojo.User;

public interface UserDao {
	/**
	 * 用户登录校验
	 * @param user
	 * @return
	 */
	public User loginDao(String uname, String pwd);
}
