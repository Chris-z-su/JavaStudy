package com.sxt.dao.impl;

import java.util.List;

import com.sxt.dao.EmpDao;
import com.sxt.pojo.Emp;
import com.sxt.util.DBUtil;

public class EmpDaoImpl implements EmpDao {
	/**
	 * ��ѯ����Ա����Ϣ
	 * @return
	 */
	@Override
	public List<Emp> getAllEmpDao() {
		//����ѯ������ص�List����
		return DBUtil.executeSelect(new Emp(), "select * from emp");
	}
}

/**
 
 
 // ����JDBC����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��������
		List<Emp> list = new ArrayList<>();
		try {
			// ��ȡ����
			conn = DBUtil.getConnection();
			// ����SQL����
			String sql = "select * from emp";
			// ����SQL�������
			ps = DBUtil.getPreparedStatement(sql);
			// ��ռλ����ֵ
			// ִ��
			rs = ps.executeQuery();
			// ����
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
			// ���ؽ����
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// �ر�����Դ
			DBUtil.closedAll(rs, ps, conn);
		}
 
 
 
 
 
 * 
 */

