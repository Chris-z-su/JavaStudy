package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.DeptDao;
import com.sxt.dao.impl.DeptDaoImpl;
import com.sxt.pojo.Dept;
import com.sxt.service.DeptService;

public class DeptServiceImpl implements DeptService {
	DeptDao deptDao = new DeptDaoImpl();
	/**
	 * 添加部门
	 */
	@Override
	public int addDeptService(Dept dept) {
		return deptDao.insertDeptDao(dept);
	}
	/**
	 * 部门查询
	 * @return 
	 */
	@Override
	public List<Dept> findDeptService() {
		// TODO Auto-generated method stub
		return deptDao.getDeptListDao();
		
	}
	/**
	 * 删除部门
	 */
	@Override
	public int deleteDeptService(int deptno) {
		// TODO Auto-generated method stub
		return deptDao.deleteDeptDao(deptno);
	}
	/**
	 * 按照编号查询部门
	 */
	@Override
	public Dept updateQueryByDeptnoService(int deptno) {
		// TODO Auto-generated method stub
		return deptDao.updateQueryByDeptnoDao(deptno);
	}
	/**
	 * 修改部门信息
	 */
	@Override
	public int updateDeptService(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.updateDeptDao(dept);
	}

}
