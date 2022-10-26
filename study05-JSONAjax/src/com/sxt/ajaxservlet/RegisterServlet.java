package com.sxt.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1.获取请求的数据内容
		String username = request.getParameter("username");
		System.out.println("username="+username);
		
		//2.查询数据库：1)结果集为空，用户名可用；2)结果集不为空，用户名不可用
		//判断
		if(username==null || "".equals(username)){
			out.println("用户名不能为空！");
		}else if("sa".equals(username)){
			out.println("该用户名已存在");
		}else{
			out.println("该用户名可以使用！");
		}
	}
}
