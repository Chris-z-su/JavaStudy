package com.sxt.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * �̰߳�ȫ
 * @author Administrator
 *
 */
public class ShowRemoteIpSimpleTag extends SimpleTagSupport {
	/**
	 * �����ڵ��ø÷���֮ǰ���Ѿ�����setJspContext(JspContext pc):���뵱ǰҳ���PageContext����
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspContext jc = getJspContext();
		PageContext pc = (PageContext) jc;
		ServletRequest request = pc.getRequest();
		JspWriter out = pc.getOut();

		String ip = request.getRemoteAddr();
		out.write(ip);
	}
}
