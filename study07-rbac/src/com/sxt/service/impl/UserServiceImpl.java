package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.UserDao;
import com.sxt.dao.impl.UserDaoImpl;
import com.sxt.pojo.Employee;
import com.sxt.pojo.Menu;
import com.sxt.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	/**
	 * 用户登录
	 */
	@Override
	public Employee loginService(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.loginDao(username, password);
	}
	
	/**
	 * 按照用户id查询菜单信息
	 */
	@Override
	public List<Menu> selectMenuInfoService(int rid) {
		int pid = 0;
		//查询一级菜单
		List<Menu> menuList = userDao.selectMenuInforDao(rid, pid);
		
		//查询二级菜单
		for (Menu menu : menuList) {
			List<Menu> menuList2 = userDao.selectMenuInforDao(rid, menu.getMid());
			menu.setLm(menuList2);
		}
		
		return menuList;
	}

}
