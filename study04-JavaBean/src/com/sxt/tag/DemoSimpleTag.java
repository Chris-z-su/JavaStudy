package com.sxt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DemoSimpleTag extends SimpleTagSupport {
	/**
	 * �������ݲ���ʾ
	 */
	/*@Override
	public void doTag() throws JspException, IOException {

	}*/
	/**
	 * ������������ʾ
	 */
	@Override
	public void doTag() throws JspException, IOException {
		/*//�õ���������
		JspFragment jf = getJspBody();
		//ʹ���ַ������
		PageContext pc = (PageContext) getJspContext();
		JspWriter out = pc.getOut();
		//�������
		jf.invoke(out);*/
		getJspBody().invoke(null);//�ȼ�
	}
}
