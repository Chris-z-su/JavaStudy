package com.sxt.tag.examples;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach1SimpleTag extends SimpleTagSupport {
	private List items;
	private String var;//¥À¥¶∫‹√Ó
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		if(items!=null){
			for (Object obj : items) {
				pc.setAttribute(var, obj);
				getJspBody().invoke(null);
			}
		}
	}
}
