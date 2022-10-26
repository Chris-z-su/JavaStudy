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
		//�������������ͻ�����Ӧ�����ݸ�ʽΪJSONʱ������Ҫ������Ӧ�ײ���Ϣ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * ��ѯ���ݿ⣺
		 * 		�����ΪJavaBean
		 * 		�����Ϊ����
		 * 
		 * ģ���ѯ���ݿ⣬�ֹ���ʽ����
		 */
		String json = "[{'province':'����ʡ'},{'province':'����ʡ'},{'province':'ɽ��ʡ'}]";
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
