package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.Employee;
import com.sxt.service.LoginService;
import com.sxt.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginService loginService = new LoginServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取前端提交的数据，根据method的值做相应的处理
		String method = request.getParameter("method");
		if("login".equals(method)){//用户登录method=login
			login(request, response);
		}else if("loginout".equals(method)){//退出登录method=loginout
			loginout(request, response);
		}
	}

	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");//验证码
		
		//获取系统生成的验证码
		HttpSession session = request.getSession();
		String verifyCode = session.getAttribute("rand").toString();
		
		//存储转发地址
		String url = "";
		
		//判断验证码是否正确，忽略大小写
		if(verifyCode.equalsIgnoreCase(verify)){
			//判断用户名和密码
			//调用service层
			Employee emp = loginService.loginService(username, password);
			if(emp != null){
				//将获取到的员工信息存放到作用域对象中
				//System.out.println(emp.getEmptype());
				session.setAttribute("emp", emp);
				url = "/system/main.jsp";
			}else{
				request.setAttribute("loginerro", "用户名或密码不正确");
				url = "/system/login.jsp";
			}
		}else{
			//跳转到登录页面
			//保存错误提示信息
			request.setAttribute("verifyerror", "验证码错误");
			url = "/system/login.jsp";
		}
		//转发
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * 注销：退出登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void loginout(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//session解除对象绑定
		HttpSession session = request.getSession();
		session.invalidate();
		
		//重定向到login.jsp页面
		response.sendRedirect(request.getContextPath()+"/system/login.jsp");
	}
}
