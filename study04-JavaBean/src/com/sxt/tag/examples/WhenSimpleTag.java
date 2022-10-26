package com.sxt.tag.examples;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenSimpleTag extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			getJspBody().invoke(null);
			//更改父标签的标记
			ChooseSimpleTag p = (ChooseSimpleTag) getParent();
			p.setFlag(true);
		}
	}
	
	
}
