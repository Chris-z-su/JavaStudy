package com.sxt.tag.examples;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach2SimpleTag extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collections = new ArrayList();
	public void setItems(Object items) {//����items�����ͣ���collections���Ԫ��
		if(items instanceof List){
			collections = (List)items;
		}else if(items instanceof Set){
			collections = (Set)items;
		}else if(items instanceof Map){
			collections = ((Map)items).entrySet();//Ԫ�أ�Map.Entry(key,value)
		}/*else if(items instanceof Object[]){
			Object[] objs = (Object[]) items;
			for (Object obj : objs) {
				collections.add(obj);
			}
		}*/else if(items.getClass().isArray()){//��һ������
			int len = Array.getLength(items);
			for (int i = 0; i < len; i++) {
				collections.add(Array.get(items, i));
			}
		}else{
			throw new RuntimeException("��֧�ֵ����ͣ�");
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		for (Object obj : collections) {
			pc.setAttribute(var, obj);
			getJspBody().invoke(null);
		}
	}
}
