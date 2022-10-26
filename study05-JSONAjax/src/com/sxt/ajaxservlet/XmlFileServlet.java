package com.sxt.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlFileServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果服务器端向客户端发送的数据格式是XML格式的话，一定要设置响应首部新
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * 在实际开发中，需要查询数据库，返回结果集
		 * 		JavaBean类型
		 * 		集合内容：
		 * 			Array、List、Map、Set
		 */
		//以文本形式构建XML格式，实际上就是String类型的字符串
		out.println("<china>");
		out.println("<province name='吉林省'>");
		out.println("<city>长春</city>");
		out.println("<city>吉林市</city>");
		out.println("<city>四平</city>");
		out.println("<city>松原</city>");
		out.println("<city>通化</city>");
		out.println("</province>");
		
		out.println("<province name='辽宁省'>");
		out.println("<city>沈阳</city>");
		out.println("<city>大连</city>");
		out.println("<city>鞍山</city>");
		out.println("<city>抚顺</city>");
		out.println("<city>铁岭</city>");
		out.println("</province>");
		
		out.println("<province name='山东省'>");
		out.println("<city>济南</city>");
		out.println("<city>青岛</city>");
		out.println("<city>威海</city>");
		out.println("<city>烟台</city>");
		out.println("<city>潍坊</city>");
		out.println("</province>");
		out.println("</china>");
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
