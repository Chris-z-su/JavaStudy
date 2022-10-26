package com.sxt.service;

import com.sxt.pojo.Employee;

public interface LoginService {

	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	Employee loginService(String username, String password);

}
