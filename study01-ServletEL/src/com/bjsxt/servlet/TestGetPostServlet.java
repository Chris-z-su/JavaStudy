package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service��doGet��doPost������:
 * 		�����Servlet��û����дservice����,�����ø���(HttpServlet)��service����
 * 		�������service�����ٸ�������ʽ���ö�Ӧ��doXXX()����.�����������������д��
 * 		doXXX()����,���ֻ�ص������doXXX()����,���û����д,��ֱ�ӵ��ø����doXXX()����
 * 		�������d0XXX()�����ж��ڱ�״̬�쳣,����doPost��doGet�ᱨ405.
 * 
 * 		doGet����:
 * 			���û����дservice����,get����ʽִ����д��doGet����
 * 		doPost����
 * 			���û����дservice����,post����ʽִ����д��doPost����
 * 		service����:
 * 			�����д����service����,�򲻹���ʲô����ʽ�򶼻�ִ��service����.
 * 			ע��:
 * 				�����service������,�����˸����service����,���ڳ���ִ����д��service������
 * 				����������󷽷����ö�Ӧ��doXXX();
 * 		�ܽ�:
 * 			һ�㿪�������п���ֱ����дservice����,Ȼ����service��������д����ʽ�ж��߼�,
 * 			���ݲ�ͬ������ʽ���ò�ͬ�Ĵ����߼�.
 * 
 * @author Administrator
 *
 */
public class TestGetPostServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("TestGetPostServlet.doGet()");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("TestGetPostServlet.doPost()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("TestGetPostServlet.service()");
	}
}
