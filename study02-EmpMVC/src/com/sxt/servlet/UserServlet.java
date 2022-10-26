package com.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Emp;
import com.sxt.pojo.User;
import com.sxt.service.EmpService;
import com.sxt.service.UserService;
import com.sxt.service.impl.EmpServiceImpl;
import com.sxt.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("UTF-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("UTF-8");
		//������Ӧͷ���������ʹ��ʲô�򿪽�������
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ����
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
//		System.out.println(uname+pwd);
		
		//����������
		UserService us = new UserServiceImpl();
		EmpService es = new EmpServiceImpl();
		
		//��¼���
		User u = us.login(uname, pwd);
		//�ж�
		if(u != null){
			//���������û���Ϣ
			List<Emp> list = es.getAllEmpService();
//			System.out.println(list);
			//����ת����empҳ��
			if(list != null){
				req.setAttribute("emp", list);
			}
			req.setAttribute("uname", uname);
			req.getRequestDispatcher("empEL.jsp").forward(req, resp);
		}else{
			//ʹ��request������
			req.setAttribute("flag", "loginFalse");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
