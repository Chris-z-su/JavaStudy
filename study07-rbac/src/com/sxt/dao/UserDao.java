package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Employee;
import com.sxt.pojo.Menu;

public interface UserDao {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	Employee loginDao(String username, String password);

	/**
	 * 按照用户id查询菜单信息
	 * @param empid
	 * @param pid
	 * @return
	 */
	List<Menu> selectMenuInforDao(int rid, int pid);

}
