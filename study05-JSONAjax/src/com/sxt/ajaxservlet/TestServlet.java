package com.sxt.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * <user username="tomcat" password="tomcat" roles="manager-gui"/>
 * 
 * @author Administrator
 *
 */
public class TestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应编码集
		//response.setCharacterEncoding("utf-8");
		//设置响应MIME类型，MIME类型告诉浏览器如何解析响应数据
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		//如果打印这句话,说明建立连接成功
		System.out.println("Connection servlet success!");
		
		//如果打印这句话,说明发送请求数据成功
		System.out.println("a = "+request.getParameter("a"));
		System.out.println("b = "+request.getParameter("b"));
		System.out.println("c = "+request.getParameter("c"));
		
		//向客户端进行响应
		out.println("Get connection service success!");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//如果打印这句话,说明建立连接成功
		System.out.println("Connection servlet success!");
		
		//如果打印这句话,说明发送请求数据成功
		System.out.println("a = "+request.getParameter("a"));
		System.out.println("b = "+request.getParameter("b"));
		
		//向客户端进行响应
		out.println("Post connection service success!");
	}
}
