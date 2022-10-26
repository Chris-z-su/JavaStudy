package com.sxt.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4SimpleTag extends SimpleTagSupport {
	/**
	 * �ı��������ݺ����
	 */
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();//���л�����ַ��������
		//��ȡ��������
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		//�ı�����
		String content = sw.getBuffer().toString();
		content = content.toUpperCase();
		//���
		PageContext pc = (PageContext) getJspContext();
		pc.getOut().write(content);
	}
	
}
