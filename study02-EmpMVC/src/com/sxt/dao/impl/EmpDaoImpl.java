package com.sxt.dao.impl;

import java.util.List;

import com.sxt.dao.EmpDao;
import com.sxt.pojo.Emp;
import com.sxt.util.DBUtil;

public class EmpDaoImpl implements EmpDao {
	/**
	 * 查询所有员工信息
	 * @return
	 */
	@Override
	public List<Emp> getAllEmpDao() {
		//将查询结果返回到List集合
		return DBUtil.executeSelect(new Emp(), "select * from emp");
	}
}

/**
 
 
 // 声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明集合
		List<Emp> list = new ArrayList<>();
		try {
			// 获取连接
			conn = DBUtil.getConnection();
			// 创建SQL命令
			String sql = "select * from emp";
			// 创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			// 给占位符赋值
			// 执行
			rs = ps.executeQuery();
			// 遍历
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getString("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
			// 返回结果集
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 关闭流资源
			DBUtil.closedAll(rs, ps, conn);
		}
 
 
 
 
 
 * 
 */

