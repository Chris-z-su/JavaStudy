package com.sxt.service.impl;

import com.sxt.dao.LoginDao;
import com.sxt.dao.impl.LoginDaoImpl;
import com.sxt.pojo.Employee;
import com.sxt.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao = new LoginDaoImpl();
	
	/**
	 * 登录验证
	 */
	@Override
	public Employee loginService(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.loginDao(username, password);
	}

}
