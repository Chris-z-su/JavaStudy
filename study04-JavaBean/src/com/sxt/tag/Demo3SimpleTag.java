package com.sxt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3SimpleTag extends SimpleTagSupport {
	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 控制主体内容重复执行
	 */
	@Override
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < count; i++) {
			getJspBody().invoke(null);
		}
	}
	
}
