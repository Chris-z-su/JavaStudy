package com.sxt.service;

public interface UserService {

	/**
	 * 修改密码
	 * @param empid
	 * @return
	 */
	int updatePwdService(String empid, String newpwd);

	/**
	 * 重置密码
	 * @param empid
	 * @return
	 */
	int resetPwdService(String empid);

}
