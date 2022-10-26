package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.PositionDao;
import com.sxt.dao.impl.PositionDaoImpl;
import com.sxt.pojo.Position;
import com.sxt.service.PositionService;

public class PositionServiceImpl implements PositionService {
	PositionDao positionDao = new PositionDaoImpl();
	/**
	 * 添加岗位
	 */
	@Override
	public int insertPositionService(Position position) {
		// TODO Auto-generated method stub
		return positionDao.insertPositionDao(position);
	}
	/**
	 * 查询所有岗位
	 */
	@Override
	public List<Position> selectPositionService() {
		// TODO Auto-generated method stub
		return positionDao.selectPositionDao();
	}
	/**
	 * 按照编号查询岗位信息
	 */
	@Override
	public Position selectPositionByPosidService(int posid) {
		// TODO Auto-generated method stub
		return positionDao.selectPositionByPosidDao(posid);
	}
	/**
	 * 修改岗位信息
	 */
	@Override
	public int updatePositionService(Position position) {
		// TODO Auto-generated method stub
		return positionDao.updatePositionDao(position);
	}
	/**
	 * 删除岗位
	 */
	@Override
	public int deletePositionService(int posid) {
		// TODO Auto-generated method stub
		return positionDao.deletePositionDao(posid);
	}

}
