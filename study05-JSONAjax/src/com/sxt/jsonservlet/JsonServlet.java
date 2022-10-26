package com.sxt.jsonservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果服务器端向客户端响应的数据格式为JSON时。不需要设置响应首部信息
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * 查询数据库：
		 * 		结果集为JavaBean
		 * 		结果集为集合
		 * 
		 * 模拟查询数据库，手工方式构建
		 */
		String json = "[{'province':'吉林省'},{'province':'辽宁省'},{'province':'山东省'}]";
		out.println(json);
		
		
		
		
	}

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
		doGet(request, response);
	}

}
