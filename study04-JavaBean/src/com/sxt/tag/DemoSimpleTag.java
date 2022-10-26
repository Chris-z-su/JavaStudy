package com.sxt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DemoSimpleTag extends SimpleTagSupport {
	/**
	 * 主体内容不显示
	 */
	/*@Override
	public void doTag() throws JspException, IOException {

	}*/
	/**
	 * 让主体内容显示
	 */
	@Override
	public void doTag() throws JspException, IOException {
		/*//拿到主体内容
		JspFragment jf = getJspBody();
		//使用字符流输出
		PageContext pc = (PageContext) getJspContext();
		JspWriter out = pc.getOut();
		//输出内容
		jf.invoke(out);*/
		getJspBody().invoke(null);//等价
	}
}
