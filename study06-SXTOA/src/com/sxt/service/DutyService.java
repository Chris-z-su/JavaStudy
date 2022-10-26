package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Duty;
import com.sxt.vo.DutyEmpVo;

public interface DutyService {

	/**
	 * 按照编号查询签到记录
	 * @return
	 */
	public Duty selectDutyService(String empid);

	/**
	 * 签到
	 * @param empid
	 * @param dtdate
	 * @param signintime
	 * @return
	 */
	public int signInService(String empid, String dtdate, String signintime);

	/**
	 * 签退
	 * @param empid
	 * @param dtdate
	 * @param signouttime
	 * @return
	 */
	public int signOutService(String empid, String dtdate, String signouttime);

	/**
	 * 查询数据总行数
	 * @return
	 */
	public int selectSignCountService();

	/**
	 * 查询所有签到记录
	 * @param startRow
	 * @param pagesize
	 * @return
	 */
	public List<DutyEmpVo> queryAllSignService(int startRow, int pagesize);

	/**
	 * 多条件分页查询
	 * @param startRow
	 * @param pagesize
	 * @param empid
	 * @param deptno
	 * @param dtdate
	 * @return
	 */
	public List<DutyEmpVo> queryAllSignArgsService(int startRow, int pagesize,
			String empid, String deptno, String dtdate);

}
