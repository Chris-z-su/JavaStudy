package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.Employee;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码格式
		request.setCharacterEncoding("UTF-8");
		//设置相应编码格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取前端页面提交的数据
		//根据method的值的不同，调用不同的处理方法
		String method = request.getParameter("method");
		if("updatepwd".equals(method)){//修改密码method=updatepwd
			updatepwd(request, response);
		}else if("resetpwd".equals(method)){//重置密码method=resetpwd
			resetpwd(request, response);
		}
		
	}

	/**
	 * 修改用户密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updatepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取作用域对象中的数据
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
//		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
//		String confirmpwd = request.getParameter("confirmpwd");
		
		//调用service层
		UserService userService = new UserServiceImpl();
		
		int num = userService.updatePwdService(emp.getEmpid(), newpwd);
		//判断是否修改成功
		if(num == 0){
			request.setAttribute("error", "修改失败！");
		}else{
			request.setAttribute("error", "修改成功！");
		}
		request.getRequestDispatcher("/info/myPwd.jsp").forward(request, response);
	}
	/**
	 * 重置密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void resetpwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取作用域对象中的数据
		String empid = request.getParameter("empid");
		//System.out.println(empid);
		
		//调用service层
		UserService userService = new UserServiceImpl();
		
		int num = userService.resetPwdService(empid);
		//判断是否重置成功
		if(num == 0){
			request.setAttribute("error", "重置密码失败！");
		}else{
			request.setAttribute("error", "重置密码成功！");
		}
		request.getRequestDispatcher("employeeServlet.bjsxt?method=findemp").forward(request, response);
	}
}
