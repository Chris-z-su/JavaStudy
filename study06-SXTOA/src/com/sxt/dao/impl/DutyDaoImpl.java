package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxt.dao.DutyDao;
import com.sxt.pojo.Duty;
import com.sxt.util.DBUtil;
import com.sxt.util.DateToStr;
import com.sxt.vo.DutyEmpVo;

public class DutyDaoImpl implements DutyDao {

	/**
	 * 按照id查询签到记录
	 */
	@Override
	public Duty selectDutyDao(String empid) {
		//创建Duty对象
		Duty duty = null;
		
		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			
			// 3.创建SQL命令
			String sql = "select * from duty where emprid = ? and to_char(dtdate, 'yyyy-MM-dd') = ?";
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			
			// 5.给占位符赋值
			ps.setString(1, empid);
			ps.setString(2, DateToStr.date2Str(new Date()));
			
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				duty = new Duty();
				
				duty.setDtid(rs.getInt("dtid"));
				duty.setEmprid(rs.getString("emprid"));
				
				if(rs.getDate("dtdate") != null){
					duty.setDtdate(DateToStr.sql2util(rs.getDate("dtdate")));
				}
				
				duty.setSignintime(rs.getString("signintime"));
				duty.setSignouttime(rs.getString("signouttime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return duty;
	}

	/**
	 * 签到
	 */
	@Override
	public int signInDao(String empid, String dtdate, String signintime) {
		// TODO Auto-generated method stub
		String sql = "insert into duty(dtid, emprid, dtdate, signintime) "
				+ "values(seq_duty_stid.nextval, ?, ?, ?)";
		return DBUtil.executeDML(sql, empid, DateToStr.util2sql(DateToStr.str2Date(dtdate)), signintime);
	}

	/**
	 * 签退
	 */
	@Override
	public int signOutDao(String empid, String dtdate, String signouttime) {
		// TODO Auto-generated method stub
		String sql = "update duty set signouttime = ? "
				+ "where emprid = ? and dtdate = ?";
		return DBUtil.executeDML(sql, signouttime, empid, DateToStr.util2sql(DateToStr.str2Date(dtdate)));
	}

	/**
	 * 查询数据总行数
	 */
	@Override
	public int selectSignCountDao() {
		int count = 0;//记录数据总行数
		
		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			
			// 3.创建SQL命令
			String sql = "select count(1) from employee e "
					+ "left join dept d "
					+ "on e.deptno = d.deptno "
					+ "left join duty dt "
					+ "on e.empid = dt.emprid";
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			
			// 5.给占位符赋值
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return count;
	}

	/**
	 * 查询所有签到记录
	 */
	@Override
	public List<DutyEmpVo> queryAllSignDao(int startRow, int pagesize) {
		//创建Duty对象
		List<DutyEmpVo> dutyEmpVoList = new ArrayList<DutyEmpVo>();
		
		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			
			// 3.创建SQL命令
			String sql = "select * from "
					+ "("
						+ "select * from "
							+ "("
								+ "select e.*, rownum r from "
									+ "("
										+ "select e.empid, e.realname, d.deptname, "
										+ "dt.dtdate, dt.signintime, dt.signouttime "
										+ "from employee e "
										+ "left join dept d "
										+ "on e.deptno = d.deptno "
										+ "left join duty dt "
										+ "on e.empid = dt.emprid "
										+ "order by dt.dtdate, dt.signintime"
									+ ")"
								+ " e order by rownum asc"
							+ ")"
						+ " e2 where e2.r < ?"
					+ ")"
					+ " e3 where e3.r >= ?";
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			
			// 5.给占位符赋值
			ps.setInt(1, startRow + pagesize - 1);
			ps.setInt(2, startRow);
			
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				DutyEmpVo dutyEmpVo = new DutyEmpVo();
				
				dutyEmpVo.setEmpid(rs.getString("empid"));
				dutyEmpVo.setRealname(rs.getString("realname"));
				dutyEmpVo.setDeptname(rs.getString("deptname"));
				if(rs.getDate("dtdate") != null && !"".equals(rs.getDate("dtdate"))){
					dutyEmpVo.setDtdate(DateToStr.sql2util(rs.getDate("dtdate")));
				}
				dutyEmpVo.setSignintime(rs.getString("signintime"));
				dutyEmpVo.setSignouttime(rs.getString("signouttime"));
				
				dutyEmpVoList.add(dutyEmpVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return dutyEmpVoList;
	}

	/**
	 * 多条件分页查询
	 */
	@Override
	public List<DutyEmpVo> queryAllSignArgsDao(int startRow, int pagesize,
			String empid, String deptno, String dtdate) {
		//创建Duty对象
		List<DutyEmpVo> dutyEmpVoList = new ArrayList<DutyEmpVo>();
		
		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			
			// 3.创建SQL命令
			String sql = "select * from "
					+ "("
						+ "select * from "
							+ "("
								+ "select e.*, rownum r from "
									+ "("
										+ "select e.empid, e.realname, d.deptname, "
										+ "dt.dtdate, dt.signintime, dt.signouttime "
										+ "from employee e "
										+ "left join dept d "
										+ "on e.deptno = d.deptno "
										+ "left join duty dt "
										+ "on e.empid = dt.emprid "
										+ "order by dt.dtdate, dt.signintime"
									+ ")"
								+ " e order by rownum asc"
							+ ")"
						+ " e2 where e2.r < ?"
					+ ")"
					+ " e3 where e3.r >= ? ";
			
			if(empid != null && !"".equals(empid)){
				sql += "and e3.empid like ?";
			}
			
			if(deptno != null && !"".equals(deptno)){
				sql += "and e3.deptno = ?";
			}
			
			if(dtdate != null && !"".equals(dtdate)){
				sql += "and to_char(e3.dtdate, 'yyyy-MM-dd') = ?";
			}
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			
			// 5.给占位符赋值
			ps.setInt(1, startRow + pagesize - 1);
			ps.setInt(2, startRow);
			
			ps.setObject(3, empid);
			
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				DutyEmpVo dutyEmpVo = new DutyEmpVo();
				
				dutyEmpVo.setEmpid(rs.getString("empid"));
				dutyEmpVo.setRealname(rs.getString("realname"));
				dutyEmpVo.setDeptname(rs.getString("deptname"));
				if(rs.getDate("dtdate") != null && !"".equals(rs.getDate("dtdate"))){
					dutyEmpVo.setDtdate(DateToStr.sql2util(rs.getDate("dtdate")));
				}
				dutyEmpVo.setSignintime(rs.getString("signintime"));
				dutyEmpVo.setSignouttime(rs.getString("signouttime"));
				
				dutyEmpVoList.add(dutyEmpVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return dutyEmpVoList;
	}

}
