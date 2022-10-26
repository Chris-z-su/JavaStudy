package com.sxt.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4SimpleTag extends SimpleTagSupport {
	/**
	 * 改变主体内容后输出
	 */
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();//带有缓冲的字符串输出流
		//获取主体内容
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		//改变内容
		String content = sw.getBuffer().toString();
		content = content.toUpperCase();
		//输出
		PageContext pc = (PageContext) getJspContext();
		pc.getOut().write(content);
	}
	
}
