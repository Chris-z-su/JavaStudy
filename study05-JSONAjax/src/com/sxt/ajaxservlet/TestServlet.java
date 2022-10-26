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
		//������Ӧ���뼯
		//response.setCharacterEncoding("utf-8");
		//������ӦMIME���ͣ�MIME���͸����������ν�����Ӧ����
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		//�����ӡ��仰,˵���������ӳɹ�
		System.out.println("Connection servlet success!");
		
		//�����ӡ��仰,˵�������������ݳɹ�
		System.out.println("a = "+request.getParameter("a"));
		System.out.println("b = "+request.getParameter("b"));
		System.out.println("c = "+request.getParameter("c"));
		
		//��ͻ��˽�����Ӧ
		out.println("Get connection service success!");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//�����ӡ��仰,˵���������ӳɹ�
		System.out.println("Connection servlet success!");
		
		//�����ӡ��仰,˵�������������ݳɹ�
		System.out.println("a = "+request.getParameter("a"));
		System.out.println("b = "+request.getParameter("b"));
		
		//��ͻ��˽�����Ӧ
		out.println("Post connection service success!");
	}
}
