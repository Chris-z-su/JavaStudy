package com.sxt.service.impl;

import java.util.List;

import com.sxt.dao.EmpDao;
import com.sxt.dao.impl.EmpDaoImpl;
import com.sxt.pojo.Emp;
import com.sxt.service.EmpService;

public class EmpServiceImpl implements EmpService {
	EmpDao ed = new EmpDaoImpl();
	/**
	 * ��ѯ����Ա����Ϣ
	 */
	@Override
	public List<Emp> getAllEmpService() {
		return ed.getAllEmpDao();
	}
}
