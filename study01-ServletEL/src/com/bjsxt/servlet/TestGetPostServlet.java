package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service和doGet和doPost的区别:
 * 		如果在Servlet中没有重写service方法,则会调用父类(HttpServlet)的service方法
 * 		而父类的service方法再根据请求方式调用对应的doXXX()方法.如果我们在子类中重写了
 * 		doXXX()方法,则又会回调子类的doXXX()方法,如果没有重写,则直接调用父类的doXXX()方法
 * 		而父类的d0XXX()方法中都在报状态异常,例如doPost和doGet会报405.
 * 
 * 		doGet方法:
 * 			如果没有重写service方法,get请求方式执行重写的doGet方法
 * 		doPost方法
 * 			如果没有重写service方法,post请求方式执行重写的doPost方法
 * 		service方法:
 * 			如果重写的了service方法,则不管是什么请求方式则都会执行service方法.
 * 			注意:
 * 				如果在service方法中,调用了父类的service方法,则在除了执行重写的service方法外
 * 				还会根据请求方法调用对应的doXXX();
 * 		总结:
 * 			一般开发过程中可以直接重写service方法,然后在service方法中书写请求方式判断逻辑,
 * 			根据不同的请求方式调用不同的代码逻辑.
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
