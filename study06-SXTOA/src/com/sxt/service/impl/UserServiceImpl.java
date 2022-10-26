package com.sxt.service.impl;

import com.sxt.dao.UserDao;
import com.sxt.dao.impl.UserDaoImpl;
import com.sxt.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	/**
	 * 修改密码
	 */
	@Override
	public int updatePwdService(String empid, String newpwd) {
		// TODO Auto-generated method stub
		return userDao.updatePwdDao(empid, newpwd);
	}
	/**
	 * 重置密码
	 */
	@Override
	public int resetPwdService(String empid) {
		// TODO Auto-generated method stub
		return userDao.resetPwdDao(empid);
	}

}
