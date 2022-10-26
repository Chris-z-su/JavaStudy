package com.sxt.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 线程安全
 * @author Administrator
 *
 */
public class ShowRemoteIpSimpleTag extends SimpleTagSupport {
	/**
	 * 容器在调用该方法之前，已经调用setJspContext(JspContext pc):传入当前页面的PageContext对象
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspContext jc = getJspContext();
		PageContext pc = (PageContext) jc;
		ServletRequest request = pc.getRequest();
		JspWriter out = pc.getOut();

		String ip = request.getRemoteAddr();
		out.write(ip);
	}
}
