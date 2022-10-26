package com.sxt.tag.examples;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseSimpleTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		ChooseSimpleTag p = (ChooseSimpleTag) getParent();
		if(!p.isFlag()){
			getJspBody().invoke(null);
		}
	}
}
