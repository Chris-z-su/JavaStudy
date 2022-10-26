package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Dept;

public interface DeptService {
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	public int addDeptService(Dept dept);
	/**
	 * 查询部门
	 */
	public List<Dept> findDeptService();
	/**
	 * 删除部门
	 * @param deptno
	 * @return
	 */
	public int deleteDeptService(int deptno);
	/**
	 * 根据编号查询部门
	 * @param deptno
	 * @return
	 */
	public Dept updateQueryByDeptnoService(int deptno);
	/**
	 * 修改部门信息
	 * @param dept
	 * @return
	 */
	public int updateDeptService(Dept dept);
}
