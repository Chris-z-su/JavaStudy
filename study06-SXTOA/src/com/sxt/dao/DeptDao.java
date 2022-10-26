package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Dept;

public interface DeptDao {
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	public int insertDeptDao(Dept dept);
	/**
	 * 查询部门
	 * @return
	 */
	public List<Dept> getDeptListDao();
	/**
	 * 删除部门
	 * @param deptno
	 * @return
	 */
	public int deleteDeptDao(int deptno);
	/**
	 * 按照编号查询部门
	 * @param deptno
	 * @return
	 */
	public Dept updateQueryByDeptnoDao(int deptno);
	/**
	 * 修改部门信息
	 * @param dept
	 * @return
	 */
	public int updateDeptDao(Dept dept);
}
