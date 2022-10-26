package com.sxt.tag.examples;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseSimpleTag extends SimpleTagSupport {
	private boolean flag;//±ê¼Ç

	public boolean isFlag() {//isFlag==getFlag
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
	
}
