package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response��Ӧѧϰ��
 * 		���ã�
 * 			ʹ�øö������������������Ӧ
 * 		�ص�:
 * 			��װ��Ŀ��ͻ��˵���Ϣ
 * 		ʹ�ã�
 * 			������Ӧ��
 * 				����:��Ϊ��������Ӧ״̬��,������Ҫ����
 * 				ʹ��:resp.sendError(int sc, String msag);
 * 				����:
 * 					int sc:״̬��
 * 					msg:״̬��Ϣ
 * 			������Ӧͷ
 * 				resp.setHeader(String name,String value);//ͬ���Ḳ��
 * 				resp.addHeader(String name,String value);//ͬ�����Ḳ��
 * 			������Ӧʵ��
 * 				resp.getWriter().write("ʵ������");
 * 				ע��:
 * 					ʵ������:����+HTML+css+js��
 * 			��ȡ��Ӧ���������
 * 				resp.getOutPutStream();
 *		��������:
 *			ÿ�����󶼻����´���,�������,����.
 * 	ע��:
 * 		������Ӧ�����ʽ:
 * 			//������Ӧʵ��ı����ʽ
				resp.setCharacterEncoding("utf-8");
			//������Ӧͷ���������ʹ��ʲô�򿪽�������
				resp.setContentType("text/html;charset=utf-8");
 * 
 * 
 * @author Administrator
 *
 */
public class TestResponse extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		//������Ӧͷ���������ʹ��ʲô�򿪽�������
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ����
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//����������Ϣ
		System.out.println(uname+"/"+pwd);
		
		//��Ӧ����
		//������Ӧʵ��
		resp.getWriter().write("��ã�");
	}
}
