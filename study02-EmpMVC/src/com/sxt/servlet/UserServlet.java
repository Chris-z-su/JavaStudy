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
		//设置请求编码格式
		req.setCharacterEncoding("UTF-8");
		//设置响应编码格式
		resp.setCharacterEncoding("UTF-8");
		//设置响应头告诉浏览器使用什么打开解析数据
		resp.setContentType("text/html;charset=utf-8");
		
		//获取请求
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
//		System.out.println(uname+pwd);
		
		//处理请求结果
		UserService us = new UserServiceImpl();
		EmpService es = new EmpServiceImpl();
		
		//登录检测
		User u = us.login(uname, pwd);
		//判断
		if(u != null){
			//查找所有用户信息
			List<Emp> list = es.getAllEmpService();
//			System.out.println(list);
			//请求转发到emp页面
			if(list != null){
				req.setAttribute("emp", list);
			}
			req.setAttribute("uname", uname);
			req.getRequestDispatcher("empEL.jsp").forward(req, resp);
		}else{
			//使用request作用域
			req.setAttribute("flag", "loginFalse");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
