package com.sxt.dao.impl;

import java.util.List;

import com.sxt.dao.UserDao;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	/**
	 * 用户登录
	 */
	@Override
	public User loginDao(String uname, String pwd) {
		// 将查询结果返回到List集合
		List<User> list = DBUtil.executeSelect(new User(),
				"select * from User where uname = ? and pwd = ?", uname, pwd);
		// 创建User对象
		User user = null;
		for (User tmp : list) {
			user = tmp;
		}
		return user;
	}
}
