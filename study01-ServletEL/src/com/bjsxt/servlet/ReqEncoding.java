package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request请求乱码问题：
 * 			get方式:
 * 				修改tomcat的server.xml配置文件,在8080端口号设置的标签中增加属性useBodyEncodingForURI:
 * 							<Connector port="8080" protocol="HTTP/1.1"
				               connectionTimeout="20000"
				               redirectPort="8443" useBodyEncodingForURI="true"/>
				 在获取请求信息之前设置请求编码格式:
				 	req.setCharacterEncoding("utf-8");
 * 			post方式:
 * 				在获取请求信息之前设置请求编码格式:
 * 					req.setCharacterEncoding("utf-8");
 *			万能方式(反编码):
 *				String str=new String(req.getParameter("键名").getBytes("iso-8859-1"),"utf-8");	
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
