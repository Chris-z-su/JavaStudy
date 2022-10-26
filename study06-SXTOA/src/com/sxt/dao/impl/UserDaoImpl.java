package com.sxt.dao.impl;

import com.sxt.dao.UserDao;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	/**
	 * 修改密码
	 */
	@Override
	public int updatePwdDao(String empid, String newpwd) {
		// TODO Auto-generated method stub
		String sql = "update employee set password = ? where empid = ?";
		return DBUtil.executeDML(sql, newpwd, empid);
	}

	/**
	 * 重置密码
	 */
	@Override
	public int resetPwdDao(String empid) {
		// TODO Auto-generated method stub
		String sql = "update employee set password = '123456' where empid = ?";
		return DBUtil.executeDML(sql, empid);
	}

}
