package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Position;

public interface PositionDao {
	/**
	 * 添加岗位
	 * @param position
	 * @return
	 */
	public int insertPositionDao(Position position);
	/**
	 * 查询全部岗位
	 * @return
	 */
	public List<Position> selectPositionDao();
	/**
	 * 按照编号查询岗位信息
	 * @param posid
	 * @return
	 */
	public Position selectPositionByPosidDao(int posid);
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	public int updatePositionDao(Position position);
	/**
	 * 根据ID删除岗位
	 * @param posid
	 * @return
	 */
	public int deletePositionDao(int posid);

}
