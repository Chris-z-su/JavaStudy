package com.sxt.dao.impl;

import java.util.List;

import com.sxt.dao.UserDao;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	/**
	 * �û���¼
	 */
	@Override
	public User loginDao(String uname, String pwd) {
		// ����ѯ������ص�List����
		List<User> list = DBUtil.executeSelect(new User(),
				"select * from User where uname = ? and pwd = ?", uname, pwd);
		// ����User����
		User user = null;
		for (User tmp : list) {
			user = tmp;
		}
		return user;
	}
}
