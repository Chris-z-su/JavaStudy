package com.sxt.tag.examples;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HtmlFilterSimpleTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		//创建一个带有缓冲区的字符串输出流
		StringWriter sw = new StringWriter();
		//把主体内容搞到缓冲流中
		getJspBody().invoke(sw);
		//改变内容中的特殊HTML标记：> < & " '
		String content = sw.getBuffer().toString();
		content = htmlFilter(content);
		//自己输出
		PageContext pc = (PageContext) getJspContext();
		pc.getOut().write(content);
	}

	private String htmlFilter(String message) {
		if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
	}
}
