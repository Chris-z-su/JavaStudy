package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxt.dao.UserDao;
import com.sxt.pojo.Employee;
import com.sxt.pojo.Menu;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	/**
	 * 用户登录
	 */
	@Override
	public Employee loginDao(String username, String password) {
		//声明对象
		Employee emp = null;
		
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取连接
			conn = DBUtil.getConnection();
			//创建SQL命令
			String sql = "select * from employee where empid = ? and password = ?";
			//创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//给占位符赋值
			ps.setString(1, username);
			ps.setString(2, password);
			//执行
			rs = ps.executeQuery();
			//遍历输出
			while(rs.next()){
				String empid = rs.getString("empid");
				String realname = rs.getString("realname");
				String sex = rs.getString("sex");
				Date birthdate = rs.getDate("birthdate");
				Date hiredate = rs.getDate("hiredate");
				Date leavedate = rs.getDate("leavedate");
				int onduty = rs.getInt("onduty");
				int emptype = rs.getInt("emptype");
				String phone = rs.getString("phone");
				String qq = rs.getString("qq");
				String emercontactperson = rs.getString("emercontactperson");
				String idcard = rs.getString("idcard");
				int rid=rs.getInt("rid");
				emp = new Employee(empid, password, realname, sex, birthdate, hiredate, leavedate, onduty, emptype, phone, qq, emercontactperson, idcard, rid);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			//关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		//返回结果集
		return emp;
	}

	/**
	 * 按照用户id查询菜单信息
	 */
	@Override
	public List<Menu> selectMenuInforDao(int rid, int pid) {
		//声明对象
		List<Menu> menuList = new ArrayList<>();
		
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取连接
			conn = DBUtil.getConnection();
			//创建SQL命令
			String sql = "select * from r_menu rm "
					+ "join t_menu tm "
					+ "on rm.mid = tm.mid "
					+ "where rid = ? and pid = ?";
			//创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//给占位符赋值
			ps.setInt(1, rid);
			ps.setInt(2, pid);
			//执行
			rs = ps.executeQuery();
			//遍历输出
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMurl(rs.getString("murl"));
				menu.setPid(rs.getInt("pid"));
				menuList.add(menu);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			//关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return menuList;
	}

}
