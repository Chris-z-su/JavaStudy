package com.bjsxt.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AServlet.service()");
//		req.getRequestDispatcher("b").forward(req, resp);
		new BServlet().service(req, resp);
	}
}
