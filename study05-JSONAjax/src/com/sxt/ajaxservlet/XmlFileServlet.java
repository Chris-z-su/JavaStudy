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
		//�������������ͻ��˷��͵����ݸ�ʽ��XML��ʽ�Ļ���һ��Ҫ������Ӧ�ײ���
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * ��ʵ�ʿ����У���Ҫ��ѯ���ݿ⣬���ؽ����
		 * 		JavaBean����
		 * 		�������ݣ�
		 * 			Array��List��Map��Set
		 */
		//���ı���ʽ����XML��ʽ��ʵ���Ͼ���String���͵��ַ���
		out.println("<china>");
		out.println("<province name='����ʡ'>");
		out.println("<city>����</city>");
		out.println("<city>������</city>");
		out.println("<city>��ƽ</city>");
		out.println("<city>��ԭ</city>");
		out.println("<city>ͨ��</city>");
		out.println("</province>");
		
		out.println("<province name='����ʡ'>");
		out.println("<city>����</city>");
		out.println("<city>����</city>");
		out.println("<city>��ɽ</city>");
		out.println("<city>��˳</city>");
		out.println("<city>����</city>");
		out.println("</province>");
		
		out.println("<province name='ɽ��ʡ'>");
		out.println("<city>����</city>");
		out.println("<city>�ൺ</city>");
		out.println("<city>����</city>");
		out.println("<city>��̨</city>");
		out.println("<city>Ϋ��</city>");
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
