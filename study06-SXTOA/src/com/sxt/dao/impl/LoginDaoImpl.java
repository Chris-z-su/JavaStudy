package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sxt.dao.LoginDao;
import com.sxt.pojo.Dept;
import com.sxt.pojo.Employee;
import com.sxt.pojo.Position;
import com.sxt.util.DBUtil;
import com.sxt.util.DateToStr;

public class LoginDaoImpl implements LoginDao {

	/**
	 * 登录验证
	 */
	@Override
	public Employee loginDao(String username, String password) {
		//创建Employee对象
		Employee employee = null;
		
		//声明JDBC集合
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动
			//2.获取连接对象
			conn = DBUtil.getConnection();
			//3.创建SQL命令
			String sql = "select e.empid, e.password, e.realname, e.sex,e.birthdate, e.hiredate, "
					+ "e.leavedate, e.onduty, e.emptype, d.deptname, e2.empid mgrid, p.pname, e.phone, "
					+ "e.qq, e.emercontactperson, e.idcard "
					+ "from employee e "
					+ "join dept d "
					+ "on e.deptno=d.deptno "
					+ "join position p "
					+ "on e.posid=p.posid "
					+ "join employee e2 "
					+ "on e.mgrid=e2.empid "
					+ "where e.empid = ? and e.password = ?";
			//4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//5.给占位符赋值
			ps.setString(1, username);
			ps.setString(2, password);
			//6.遍历输出
			rs = ps.executeQuery();
			while(rs.next()){
				employee = new Employee();
				employee.setEmpid(rs.getString("empid"));
				employee.setPassword(rs.getString("password"));
				employee.setRealname(rs.getString("realname"));
				employee.setSex(rs.getString("sex"));
				
				//生日
				if(rs.getDate("birthdate") != null){
					employee.setBirthdate(DateToStr.sql2util(rs.getDate("birthdate")));
				}
				//入职日期
				if(rs.getDate("hiredate") != null){
					employee.setHiredate(DateToStr.sql2util(rs.getDate("hiredate")));
				}
				//离职日期
				if(rs.getDate("leavedate") != null){
					employee.setLeavedate(DateToStr.sql2util(rs.getDate("leavedate")));
				}
				//是否在职
				employee.setOnduty(rs.getInt("onduty"));
				//员工角色
				employee.setEmptype(rs.getInt("emptype"));
				
				//所属部门
				Dept dept = new Dept();
				dept.setDeptname(rs.getString("deptname"));
				employee.setDept(dept);

				//所属岗位
				Position position = new Position();
				position.setPname(rs.getString("pname"));
				employee.setPosition(position);
				
				//直接上级
				Employee mgremp = new Employee();
				mgremp.setEmpid(rs.getString("mgrid"));
				if(rs.getString("mgrid") != null){
					employee.setMgremp(mgremp);
				}
				
				employee.setPhone(rs.getString("phone"));
				employee.setQq(rs.getString("qq"));
				employee.setEmercontactperson(rs.getString("emercontactperson"));
				employee.setIdcard(rs.getString("idcard"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		//8.返回结果集
		return employee;
	}

}
