package com.sxt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2SimpleTag extends SimpleTagSupport {
	/**
	 * ���ƽ�����ǩ���ʣ��JSP���ݲ�ִ��
	 */
	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
	
}
