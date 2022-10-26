package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Resquest�����ȡ������Ϣ
 *		����:
 *			����˴˴����������������Ϣ
 *		�ص�:
 *			�ɷ���������.
 *			һ�����󴴽�һ��,ÿ������request�������µ�.
 *		��������:
 *			һ��������,�������������.
 *		ʹ�ã�
 *			��ȡ��������Ϣ
 *			��ȡ����ͷ��Ϣ
 *			��ȡ����ʵ����Ϣ

 * @author Administrator
 *
 */
public class TestRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-------------����������----------------");
		//��ȡ������Ϣ
			//��ȡ����ʽ
			String method = req.getMethod();
			System.out.println(method);//GET
			//��ȡ����URL
			String url = req.getRequestURL().toString();
			System.out.println(url);//http://192.168.143.146:8080/01-servlet/re
			//��ȡ����Э��
			String schema=req.getScheme();
			System.out.println(schema);//http
			//��ȡ����URI��Ϣ
			String uri = req.getRequestURI();
			System.out.println(uri);///01-servlet/re
			//��ȡget����ʽ������ʵ��,post��ʽû�и÷�����
			String data=req.getQueryString();
			System.out.println(data);//uname=zhangsan&pwd=123
		//��ȡ����ͷ����
			System.out.println("-----------------����ͷ����------------------");
			//���ݼ�����ȡ���ݣ�������������ڷ���null�����ᱨ��
			String header = req.getHeader("User-Agent");
			System.out.println(header);//Mozilla/5.0 (Windows NT 10.0; WOW64; rv:62.0) Gecko/20100101 Firefox/62.0
			//��ȡ������ö�ټ���
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
			
		//��ȡ����ʵ��
			System.out.println("-------------����ʵ��---------------");
			//���ݼ�����ȡʵ�����ݣ����û�з���null
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			System.out.println(uname+"/"+pwd);//zhangsan/123
			
			//��ȡͬ����ֵͬ������ʵ������
			String[] favs = req.getParameterValues("fav");//����һ������
			for(String fav:favs){
				System.out.println(fav);
			}
			
			//��ȡ������ö��
			Enumeration parameterNames = req.getParameterNames();
			while(parameterNames.hasMoreElements()){
				String name = (String) parameterNames.nextElement();
				System.out.println(name);
			}
		//��ȡ������������
			System.out.println("--------------��ȡ������������----------------");
			//��ȡ�ͻ���IP
			String ip = req.getRemoteAddr();

			//��ȡ�ͻ��˶˿ں�
			int post = req.getRemotePort();
			
			//��ȡ�ͻ���������
			String host = req.getRemoteHost();
			//��ӡ
			System.out.println(ip+"/"+post+"/"+host);//192.168.143.146/61381/192.168.143.146
			
	}
}
