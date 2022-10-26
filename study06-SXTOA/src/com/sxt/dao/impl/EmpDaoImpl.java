package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxt.dao.EmpDao;
import com.sxt.pojo.Dept;
import com.sxt.pojo.Employee;
import com.sxt.pojo.Position;
import com.sxt.util.DBUtil;
import com.sxt.util.DateToStr;

public class EmpDaoImpl implements EmpDao {
	/**
	 * 查询全部员工信息
	 */
	@Override
	public List<Employee> selectEmployeeDao() {
		// 创建List集合
		List<Employee> empList = new ArrayList<Employee>();

		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			// 3.创建SQL命令
			String sql = "select e.empid, e.realname, d.deptname, p.pname, e.hiredate, "
					+ "e.leavedate, e.phone, e.onduty "
					+ "from employee e "
					+ "join dept d on e.deptno=d.deptno "
					+ "join position p on e.posid=p.posid "
					+ "order by p.posid";
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			// 5.给占位符赋值
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpid(rs.getString("empid"));
				employee.setRealname(rs.getString("realname"));

				Dept dept = new Dept();
				dept.setDeptname(rs.getString("deptname"));
				employee.setDept(dept);

				Position position = new Position();
				position.setPname(rs.getString("pname"));
				employee.setPosition(position);

				employee.setHiredate(rs.getDate("hiredate"));
				employee.setLeavedate(rs.getDate("leavedate"));
				employee.setPhone(rs.getString("phone"));
				employee.setOnduty(rs.getInt("onduty"));

				empList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return empList;
	}

	/**
	 * 查询上级信息
	 */
	@Override
	public List<Employee> selectMgrDao() {
		// 创建List集合
		List<Employee> mgrList = new ArrayList<Employee>();

		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			// 3.创建SQL命令
			String sql = "select e4.empid, e4.realname from employee e4 "
					+ "where e4.empid in "
					+ "(select e2.empid from employee e1 join employee e2 on e1.mgrid = e2.empid) "
					+ "or e4.empid in "
					+ "(select e3.empid from employee e3 where e3.mgrid is null) "
					+ "or e4.empid in "
					+ "(select empid from employee where posid = 1 or posid = 2 or posid = 3 or posid = 6)";
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			// 5.给占位符赋值
			rs = ps.executeQuery();
			// 6.遍历输出
			while (rs.next()) {
				Employee employee = new Employee();

				employee.setEmpid(rs.getString("empid"));
				employee.setRealname(rs.getString("realname"));

				mgrList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		// 8.返回结果集
		return mgrList;
	}

	/**
	 * 添加员工信息
	 */
	@Override
	public int insertEmployeeDao(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "insert into employee"
				+ "(empid, password, deptno, posid, mgrid, "
				+ "realname, sex, birthdate, hiredate, onduty, "
				+ "emptype, phone, qq, emercontactperson, idcard) "
				+ "values(?, '123456', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] obj = {
				emp.getEmpid(), emp.getDept().getDeptno(),
				emp.getPosition().getPosid(), emp.getMgremp().getEmpid(),
				emp.getRealname(), emp.getSex(), DateToStr.util2sql(emp.getBirthdate()), DateToStr.util2sql(emp.getHiredate()),
				emp.getOnduty(), emp.getEmptype(), emp.getPhone(), emp.getQq(), emp.getEmercontactperson(),
				emp.getIdcard()
		};
		return DBUtil.executeDML(sql, obj);
	}

	/**
	 * 按照编号查询员工信息
	 */
	@Override
	public Employee selectQueryByEmpidDao(String empid) {
		// 创建Employee对象
		Employee employee = new Employee();

		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			// 3.创建SQL命令
			String sql = "select e.empid, e.password, e.realname, e.sex,e.birthdate, e.hiredate, "
					+ "e.leavedate, e.onduty, d.deptname, e2.empid mgrid, p.pname, e.phone, "
					+ "e.qq, e.emercontactperson, e.idcard "
					+ "from employee e "
					+ "join dept d "
					+ "on e.deptno=d.deptno "
					+ "join position p "
					+ "on e.posid=p.posid "
					+ "join employee e2 "
					+ "on e.mgrid=e2.empid "
					+ "where e.empid = ?";
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			// 5.给占位符赋值
			ps.setString(1, empid);
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				employee.setEmpid(rs.getString("empid"));
				employee.setPassword(rs.getString("password"));
				employee.setRealname(rs.getString("realname"));
				employee.setSex(rs.getString("sex"));
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
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return employee;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public int updateEmployeeDao(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "";
		if(emp.getLeavedate() != null && !"".equals(emp.getLeavedate())){
			sql = "update employee set "
				+ "deptno = ?, posid = ?, mgrid = ?, realname = ?, "
				+ "sex = ?, birthdate = ?, hiredate = ?, leavedate = ?, onduty = ?, "
				+ "phone = ?, qq = ?, emercontactperson = ?, idcard = ? where empid = ?";
			Object[] obj = {
					emp.getDept().getDeptno(), emp.getPosition().getPosid(), 
					emp.getMgremp().getEmpid(), emp.getRealname(), emp.getSex(), 
					DateToStr.util2sql(emp.getBirthdate()), DateToStr.util2sql(emp.getHiredate()), DateToStr.util2sql(emp.getLeavedate()),
					emp.getOnduty(), emp.getPhone(), emp.getQq(), emp.getEmercontactperson(), emp.getIdcard(), emp.getEmpid()
			};
			return DBUtil.executeDML(sql, obj);
		}else{
			sql = "update employee set "
				+ "deptno = ?, posid = ?, mgrid = ?, realname = ?, "
				+ "sex = ?, birthdate = ?, hiredate = ?, leavedate = ?, onduty = ?, "
				+ "phone = ?, qq = ?, emercontactperson = ?, idcard = ? where empid = ?";
			Object[] obj = {
					emp.getDept().getDeptno(), emp.getPosition().getPosid(),  
					emp.getMgremp().getEmpid(), emp.getRealname(), emp.getSex(), 
					DateToStr.util2sql(emp.getBirthdate()), DateToStr.util2sql(emp.getHiredate()), null, 
					emp.getOnduty(), emp.getPhone(), emp.getQq(), emp.getEmercontactperson(), emp.getIdcard(), emp.getEmpid()
			};
			return DBUtil.executeDML(sql, obj);
		}
	}

	/**
	 * 删除员工信息:
	 * 		修改员工在职状态：1 在职，	0 离职
	 */
	@Override
	public int deleteEmpDao(String empid) {
		// TODO Auto-generated method stub
//		String sql = "delete from employee where empid = ?";
		String sql = "update employee set onduty = 0, leavedate = ? where empid = ?";
		return DBUtil.executeDML(sql, DateToStr.util2sql(new Date()), empid);
	}

	/**
	 * 多条件查询员工信息
	 */
	@Override
	public List<Employee> selectEmployeeByArgsDao(String empid, String deptno,
			String onduty, String hiredate) {
		// 创建List集合
		List<Employee> empList = new ArrayList<Employee>();
//		int count = 0;//存储有效条件的数量
		//System.out.println(count);
		
		// 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			// 2.获取连接对象
			conn = DBUtil.getConnection();
			// 3.创建SQL命令
			String sql = "select e.empid,e.realname,d.deptname,p.pname,e.hiredate,e.phone,e.onduty "
					+ "from employee e "
					+ "join dept d on e.deptno=d.deptno "
					+ "join position p on e.posid=p.posid "
					+ "where 1 = 1 ";
			if(empid != null && !"".equals(empid)){
				sql += "and e.empid like ?";
//				count++;
			}
			
			if(deptno != null && !"".equals(deptno)){
				sql += "and d.deptno = ?";
//				count++;
			}
			
			if(onduty != null && !"".equals(onduty)){
				sql += "and e.onduty = ?";
//				count++;
			}
			
			if(hiredate != null && !"".equals(hiredate)){
				sql += "and to_char(e.hiredate, 'yyyy-MM-dd') = ?";
//				count++;
			}
			
			// 4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			// 5.给占位符赋值
//			String[] args = {empid, deptno, onduty, hiredate};
//			if(args != null){
//				for (int i = 0; i < count; i++) {
//					if(args[i] == null){
//						i--;
//						continue;
//					}
//					ps.setObject(i + 1, args[i]);
//				}
//			}
			
			if((empid != null && !"".equals(empid)) && (hiredate != null && !"".equals(hiredate))){
				ps.setObject(1, "%" + empid + "%");
				ps.setObject(2, deptno);
				ps.setObject(3, onduty);
				ps.setObject(4, hiredate);
			}
			if((empid == null || "".equals(empid)) && (hiredate != null && !"".equals(hiredate))){
				ps.setObject(1, deptno);
				ps.setObject(2, onduty);
				ps.setObject(3, hiredate);
			}
			if((empid != null && !"".equals(empid)) && (hiredate == null || "".equals(hiredate))){
				ps.setObject(1, "%" + empid + "%");
				ps.setObject(2, deptno);
				ps.setObject(3, onduty);
			}
			if((empid == null || "".equals(empid)) && (hiredate == null || "".equals(hiredate))){
				ps.setObject(1, deptno);
				ps.setObject(2, onduty);
			}
			
			// 6.遍历输出
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpid(rs.getString("empid"));
				employee.setRealname(rs.getString("realname"));

				Dept dept = new Dept();
				dept.setDeptname(rs.getString("deptname"));
				employee.setDept(dept);

				Position position = new Position();
				position.setPname(rs.getString("pname"));
				employee.setPosition(position);

				employee.setHiredate(rs.getDate("hiredate"));
				employee.setPhone(rs.getString("phone"));
				employee.setOnduty(rs.getInt("onduty"));

				empList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		return empList;
	}
}
