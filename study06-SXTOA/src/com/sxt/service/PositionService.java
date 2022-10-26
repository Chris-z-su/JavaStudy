package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Position;

public interface PositionService {
	/**
	 * 添加部岗位
	 * @param position
	 * @return
	 */
	public int insertPositionService(Position position);
	/**
	 * 查询所有岗位
	 * @return
	 */
	public List<Position> selectPositionService();
	/**
	 * 按照编号查询岗位信息
	 * @param posid
	 * @return
	 */
	public Position selectPositionByPosidService(int posid);
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	public int updatePositionService(Position position);
	/**
	 * 删除岗位信息
	 * @param posid
	 * @return
	 */
	public int deletePositionService(int posid);
	
}
