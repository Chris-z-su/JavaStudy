package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxt.dao.PositionDao;
import com.sxt.pojo.Position;
import com.sxt.util.DBUtil;

public class PositionDaoImpl implements PositionDao {
	/**
	 * 添加岗位
	 */
	@Override
	public int insertPositionDao(Position position) {
		String sql = "insert into position(posid, pname, pdesc) values(?, ?, ?)";
		return DBUtil.executeDML(sql, position.getPosid(), position.getPname(), position.getPdesc());
	}
	/**
	 * 查询全部岗位
	 */
	@Override
	public List<Position> selectPositionDao() {
		//创建List集合
		List<Position> positionList = new ArrayList<Position>();
		
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动
			//2.获取连接对象
			conn = DBUtil.getConnection();
			//3.创建SQL命令
			String sql = "select * from position";
			//4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//5.给占位符赋值
			//6.遍历输出
			rs = ps.executeQuery();
			while(rs.next()){
				Position position = new Position();
				position.setPosid(rs.getInt("posid"));
				position.setPname(rs.getString("pname"));
				position.setPdesc(rs.getString("pdesc"));
				positionList.add(position);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//8.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		//7.返回结果集
		return positionList;
	}
	/**
	 * 按照编号查询岗位信息
	 */
	@Override
	public Position selectPositionByPosidDao(int posid) {
		//创建Position对象
		Position position = new Position();
		
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.加载驱动
			//2.获取连接对象
			conn = DBUtil.getConnection();
			//3.创建SQL命令
			String sql = "select * from position where posid = ?";
			//4.创建SQL命令对象
			ps = DBUtil.getPreparedStatement(sql);
			//5.给占位符赋值
			ps.setInt(1, posid);
			//6.遍历输出
			rs = ps.executeQuery();
			while(rs.next()){
				position.setPosid(rs.getInt("posid"));
				position.setPname(rs.getString("pname"));
				position.setPdesc(rs.getString("pdesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//7.关闭资源
			DBUtil.closedAll(rs, ps, conn);
		}
		//8.返回结果集
		return position;
	}
	/**
	 * 修改岗位信息
	 */
	@Override
	public int updatePositionDao(Position position) {
		// TODO Auto-generated method stub
		String sql = "update position set pname = ?, pdesc = ? where posid = ?";
		return DBUtil.executeDML(sql, position.getPname(), position.getPdesc(), position.getPosid());
	}
	/**
	 * 根据ID删除岗位信息
	 */
	@Override
	public int deletePositionDao(int posid) {
		// TODO Auto-generated method stub
		String sql = "delete from position where posid = ?";
		return DBUtil.executeDML(sql, posid);
	}

}
