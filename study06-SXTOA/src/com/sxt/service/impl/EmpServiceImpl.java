package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.EmpDao;
import com.sxt.dao.impl.EmpDaoImpl;
import com.sxt.pojo.Employee;
import com.sxt.service.EmpService;

public class EmpServiceImpl implements EmpService {
	EmpDao empDao = new EmpDaoImpl();

	/**
	 * 查询全部员工信息
	 */
	@Override
	public List<Employee> selectEmployeeService() {
		// TODO Auto-generated method stub
		return empDao.selectEmployeeDao();
	}

	/**
	 * 查询上级信息
	 */
	@Override
	public List<Employee> selectMgrList() {
		// TODO Auto-generated method stub
		return empDao.selectMgrDao();
	}

	/**
	 * 添加员工信息
	 */
	@Override
	public int insertEmployeeService(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.insertEmployeeDao(employee);
	}

	/**
	 * 按照编号查询员工信息
	 */
	@Override
	public Employee selectQueryByEmpidService(String empid) {
		// TODO Auto-generated method stub
		return empDao.selectQueryByEmpidDao(empid);
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public int updateEmployeeService(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.updateEmployeeDao(employee);
	}

	/**
	 * 删除员工信息
	 */
	@Override
	public int deleteEmpService(String empid) {
		// TODO Auto-generated method stub
		return empDao.deleteEmpDao(empid);
	}

	/**
	 * 多条件查询员工信息
	 */
	@Override
	public List<Employee> selectEmployeeByArgsService(String empid,
			String deptno, String onduty, String hiredate) {
		// TODO Auto-generated method stub
		return empDao.selectEmployeeByArgsDao(empid, deptno, onduty, hiredate);
	}
}
