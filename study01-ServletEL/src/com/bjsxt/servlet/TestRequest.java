package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Resquest对象获取请求信息
 *		作用:
 *			封存了此次请求的所有请求信息
 *		特点:
 *			由服务器创建.
 *			一次请求创建一次,每次请求request对象都是新的.
 *		生命周期:
 *			一次请求内,请求结束即销毁.
 *		使用：
 *			获取请求行信息
 *			获取请求头信息
 *			获取请求实体信息

 * @author Administrator
 *
 */
public class TestRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-------------请求行数据----------------");
		//获取请求信息
			//获取请求方式
			String method = req.getMethod();
			System.out.println(method);//GET
			//获取请求URL
			String url = req.getRequestURL().toString();
			System.out.println(url);//http://192.168.143.146:8080/01-servlet/re
			//获取请求协议
			String schema=req.getScheme();
			System.out.println(schema);//http
			//获取请求URI信息
			String uri = req.getRequestURI();
			System.out.println(uri);///01-servlet/re
			//获取get请求方式的请求实体,post方式没有该方法。
			String data=req.getQueryString();
			System.out.println(data);//uname=zhangsan&pwd=123
		//获取请求头数据
			System.out.println("-----------------请求头数据------------------");
			//根据键名获取数据：如果键名不存在返回null，不会报错。
			String header = req.getHeader("User-Agent");
			System.out.println(header);//Mozilla/5.0 (Windows NT 10.0; WOW64; rv:62.0) Gecko/20100101 Firefox/62.0
			//获取键名的枚举集合
			Enumeration headerNames = req.getHeaderNames();
			while(headerNames.hasMoreElements()){
				String name=(String) headerNames.nextElement();
				String value=req.getHeader(name);
				System.out.println(name+":"+value);
			}
//			host:192.168.143.146:8080
//			user-agent:Mozilla/5.0 (Windows NT 10.0; WOW64; rv:62.0) Gecko/20100101 Firefox/62.0
//			accept:text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//			accept-language:zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//			accept-encoding:gzip, deflate
//			cookie:JSESSIONID=AC7BA7A1F6D5579D4D7BD08FCD258A62
//			connection:keep-alive
//			upgrade-insecure-requests:1
//			cache-control:max-age=0
			
		//获取请求实体
			System.out.println("-------------请求实体---------------");
			//根据键名获取实体数据，如果没有返回null
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			System.out.println(uname+"/"+pwd);//zhangsan/123
			
			//获取同名不同值的请求实体数据
			String[] favs = req.getParameterValues("fav");//返回一个数组
			for(String fav:favs){
				System.out.println(fav);
			}
			
			//获取键名的枚举
			Enumeration parameterNames = req.getParameterNames();
			while(parameterNames.hasMoreElements()){
				String name = (String) parameterNames.nextElement();
				System.out.println(name);
			}
		//获取其他请求数据
			System.out.println("--------------获取其他请求数据----------------");
			//获取客户端IP
			String ip = req.getRemoteAddr();

			//获取客户端端口号
			int post = req.getRemotePort();
			
			//获取客户端主机名
			String host = req.getRemoteHost();
			//打印
			System.out.println(ip+"/"+post+"/"+host);//192.168.143.146/61381/192.168.143.146
			
	}
}
