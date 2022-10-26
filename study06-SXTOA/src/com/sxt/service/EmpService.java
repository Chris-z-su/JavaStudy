package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Employee;

public interface EmpService {
	/**
	 * 查找全部员工信息
	 * 
	 * @return
	 */
	public List<Employee> selectEmployeeService();

	/**
	 * 查询上级信息
	 * 
	 * @return
	 */
	public List<Employee> selectMgrList();

	/**
	 * 添加员工信息
	 * 
	 * @param employee
	 * @return
	 */
	public int insertEmployeeService(Employee employee);

	/**
	 * 按照编号查询员工信息
	 * 
	 * @param empid
	 * @return
	 */
	public Employee selectQueryByEmpidService(String empid);

	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	public int updateEmployeeService(Employee employee);

	/**
	 * 删除员工信息
	 * @param empid
	 * @return
	 */
	public int deleteEmpService(String empid);

	/**
	 * 多条件查询员工信息
	 * @param empid
	 * @param deptno
	 * @param onduty
	 * @param hiredate
	 * @return
	 */
	public List<Employee> selectEmployeeByArgsService(String empid,
			String deptno, String onduty, String hiredate);
}
