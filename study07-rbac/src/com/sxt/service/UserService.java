package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Employee;
import com.sxt.pojo.Menu;

public interface UserService {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee loginService(String username, String password);

	/**
	 * 按照用户id查询菜单信息
	 * @param empid
	 * @return
	 */
	public List<Menu> selectMenuInfoService(int rid);

}
