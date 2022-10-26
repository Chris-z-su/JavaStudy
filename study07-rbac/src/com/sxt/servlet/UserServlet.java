package com.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.Employee;
import com.sxt.pojo.Menu;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		
		//获取表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
		//调用service层
		UserService userService = new UserServiceImpl();
		
		Employee emp = userService.loginService(username, password);
		
		if(emp != null){
			//查询当前用户的菜单信息
			List<Menu> menuList = userService.selectMenuInfoService(emp.getRid());
			System.out.println(menuList);
			
			//将用户信息存储到session对象中
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			session.setAttribute("menuList", menuList);
			
			//重定向
			response.sendRedirect(request.getContextPath()+"/system/main.jsp");
		}
		
	}
}
