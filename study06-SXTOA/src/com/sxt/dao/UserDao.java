package com.sxt.dao;

public interface UserDao {

	/**
	 * 修改密码
	 * @param empid
	 * @return
	 */
	int updatePwdDao(String empid, String newpwd);

	/**
	 * 重置密码
	 * @param empid
	 * @return
	 */
	int resetPwdDao(String empid);

}
