package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request�����������⣺
 * 			get��ʽ:
 * 				�޸�tomcat��server.xml�����ļ�,��8080�˿ں����õı�ǩ����������useBodyEncodingForURI:
 * 							<Connector port="8080" protocol="HTTP/1.1"
				               connectionTimeout="20000"
				               redirectPort="8443" useBodyEncodingForURI="true"/>
				 �ڻ�ȡ������Ϣ֮ǰ������������ʽ:
				 	req.setCharacterEncoding("utf-8");
 * 			post��ʽ:
 * 				�ڻ�ȡ������Ϣ֮ǰ������������ʽ:
 * 					req.setCharacterEncoding("utf-8");
 *			���ܷ�ʽ(������):
 *				String str=new String(req.getParameter("����").getBytes("iso-8859-1"),"utf-8");	
 * @author Administrator
 *
 */
public class ReqEncoding extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+"/"+pwd);
	}
}
