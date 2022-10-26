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
		
		//1.��ȡ�������������
		String username = request.getParameter("username");
		System.out.println("username="+username);
		
		//2.��ѯ���ݿ⣺1)�����Ϊ�գ��û������ã�2)�������Ϊ�գ��û���������
		//�ж�
		if(username==null || "".equals(username)){
			out.println("�û�������Ϊ�գ�");
		}else if("sa".equals(username)){
			out.println("���û����Ѵ���");
		}else{
			out.println("���û�������ʹ�ã�");
		}
	}
}
