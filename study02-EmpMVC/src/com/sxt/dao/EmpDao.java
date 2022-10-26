package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Emp;

public interface EmpDao {
	/**
	 * 查询所有员工信息
	 * @return
	 */
	public List<Emp> getAllEmpDao();
}
