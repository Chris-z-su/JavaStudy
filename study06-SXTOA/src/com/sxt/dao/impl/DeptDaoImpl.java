package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxt.dao.DeptDao;
import com.sxt.pojo.Dept;
import com.sxt.util.DBUtil;

public class DeptDaoImpl implements DeptDao {
	/**
	 * 添加部门
	 */
	@Override
	public int insertDeptDao(Dept dept) {
		String sql = "insert into dept(deptno, deptname, location) values(?, ?, ?)";
		return DBUtil.executeDML(sql, dept.getDeptno(), dept.getDeptname(), dept.getLocation());
	}
	/**
	 * 查询部门
	 */
	@Override
	public List<Dept> getDeptListDao() {
		//创建List集合
		List<Dept> deptList = new ArrayList<Dept>();
		
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动
			//2.获取连接对象
			conn = DBUtil.getConnection();
			//3.创建SQL命令
			String sql = "select * from dept order by deptno asc";
			//4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//5.给占位符赋值
			//6.遍历输出
			rs = ps.executeQuery();
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDeptname(rs.getString("deptname"));
				dept.setLocation(rs.getString("location"));
				deptList.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return deptList;
	}
	/**
	 * 删除部门
	 */
	@Override
	public int deleteDeptDao(int deptno) {
		String sql = "delete from dept where deptno = ?";
		return DBUtil.executeDML(sql, deptno);
	}
	/**
	 * 按照编号查询部门
	 */
	@Override
	public Dept updateQueryByDeptnoDao(int deptno) {
		//创建List集合
		Dept dept = new Dept();
		
		//创建JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动
			//2.获取连接对象
			conn = DBUtil.getConnection();
			//3.创建SQL命令
			String sql = "select * from dept where deptno = ?";
			//4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//5.给占位符赋值
			ps.setInt(1, deptno);
			//6.遍历输出
			rs = ps.executeQuery();
			while(rs.next()){
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDeptname(rs.getString("deptname"));
				dept.setLocation(rs.getString("location"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return dept;
	}
	/**
	 * 修改部门信息
	 */
	@Override
	public int updateDeptDao(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "update dept set deptname = ?, location = ? where deptno = ?";
		return DBUtil.executeDML(sql, dept.getDeptname(), dept.getLocation(), dept.getDeptno());
	}
	
}
