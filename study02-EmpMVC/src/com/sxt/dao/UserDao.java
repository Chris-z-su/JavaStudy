package com.sxt.dao;

import com.sxt.pojo.User;

public interface UserDao {
	/**
	 * �û���¼У��
	 * @param user
	 * @return
	 */
	public User loginDao(String uname, String pwd);
}
