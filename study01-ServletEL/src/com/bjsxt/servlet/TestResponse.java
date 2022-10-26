package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response响应学习：
 * 		作用：
 * 			使用该对象进行请求处理结果的响应
 * 		特点:
 * 			封装了目标客户端的信息
 * 		使用：
 * 			设置响应行
 * 				作用:人为的设置响应状态码,隐藏重要数据
 * 				使用:resp.sendError(int sc, String msag);
 * 				参数:
 * 					int sc:状态码
 * 					msg:状态消息
 * 			设置响应头
 * 				resp.setHeader(String name,String value);//同键会覆盖
 * 				resp.addHeader(String name,String value);//同键不会覆盖
 * 			设置响应实体
 * 				resp.getWriter().write("实体内容");
 * 				注意:
 * 					实体内容:数据+HTML+css+js等
 * 			获取响应输出流对象
 * 				resp.getOutPutStream();
 *		生命周期:
 *			每次请求都会重新创建,请求结束,销毁.
 * 	注意:
 * 		设置响应编码格式:
 * 			//设置响应实体的编码格式
				resp.setCharacterEncoding("utf-8");
			//设置响应头告诉浏览器使用什么打开解析数据
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
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		//设置响应头告诉浏览器使用什么打开解析数据
		resp.setContentType("text/html;charset=utf-8");
		
		//获取请求
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//处理请求信息
		System.out.println(uname+"/"+pwd);
		
		//相应处理
		//设置相应实体
		resp.getWriter().write("你好！");
	}
}
