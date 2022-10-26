package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.DutyDao;
import com.sxt.dao.impl.DutyDaoImpl;
import com.sxt.pojo.Duty;
import com.sxt.service.DutyService;
import com.sxt.vo.DutyEmpVo;

public class DutyServiceImpl implements DutyService {

	DutyDao dutyDao = new DutyDaoImpl();
	
	/**
	 * 查询签到记录
	 */
	@Override
	public Duty selectDutyService(String empid) {
		// TODO Auto-generated method stub
		return dutyDao.selectDutyDao(empid);
	}
	
	/**
	 * 签到
	 */
	@Override
	public int signInService(String empid, String dtdate, String signintime) {
		// TODO Auto-generated method stub
		return dutyDao.signInDao(empid, dtdate, signintime);
	}
	
	/**
	 * 签退
	 */
	@Override
	public int signOutService(String empid, String dtdate, String signouttime) {
		// TODO Auto-generated method stub
		return dutyDao.signOutDao(empid, dtdate, signouttime);
	}
	
	/**
	 * 查询数据总行数
	 */
	@Override
	public int selectSignCountService() {
		// TODO Auto-generated method stub
		return dutyDao.selectSignCountDao();
	}

	/**
	 * 查询所有签到记录
	 */
	@Override
	public List<DutyEmpVo> queryAllSignService(int startRow, int pagesize) {
		// TODO Auto-generated method stub
		return dutyDao.queryAllSignDao(startRow, pagesize);
	}

	/**
	 * 多条件分页查询
	 */
	@Override
	public List<DutyEmpVo> queryAllSignArgsService(int startRow, int pagesize,
			String empid, String deptno, String dtdate) {
		// TODO Auto-generated method stub
		return dutyDao.queryAllSignArgsDao(startRow, pagesize, empid, deptno, dtdate);
	}
	
}
