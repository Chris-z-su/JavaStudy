package com.sxt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2SimpleTag extends SimpleTagSupport {
	/**
	 * 控制结束标签后的剩余JSP内容不执行
	 */
	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
	
}
