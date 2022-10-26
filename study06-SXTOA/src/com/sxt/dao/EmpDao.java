package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Employee;

public interface EmpDao {
	/**
	 * 查询全部员工信息
	 * 
	 * @return
	 */
	public List<Employee> selectEmployeeDao();

	/**
	 * 查询上级信息
	 * 
	 * @return
	 */
	public List<Employee> selectMgrDao();

	/**
	 * 添加员工信息
	 * 
	 * @param employee
	 * @return
	 */
	public int insertEmployeeDao(Employee employee);

	/**
	 * 按照编号查询员工信息
	 * @param empid
	 * @return
	 */
	public Employee selectQueryByEmpidDao(String empid);

	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	public int updateEmployeeDao(Employee employee);

	/**
	 * 删除员工信息
	 * @param empid
	 * @return
	 */
	public int deleteEmpDao(String empid);

	/**
	 * 多条件查询员工信息
	 * @param empid
	 * @param deptno
	 * @param onduty
	 * @param hiredate
	 * @return
	 */
	public List<Employee> selectEmployeeByArgsDao(String empid, String deptno,
			String onduty, String hiredate);

}
