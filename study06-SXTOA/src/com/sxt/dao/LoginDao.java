package com.sxt.dao;

import com.sxt.pojo.Employee;

public interface LoginDao {

	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	Employee loginDao(String username, String password);

}
