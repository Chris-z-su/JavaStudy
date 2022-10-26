package com.sxt.xstream.test;

import java.util.ArrayList;
import java.util.List;

import com.sxt.xstream.bean.City;
import com.sxt.xstream.bean.Province;
import com.thoughtworks.xstream.XStream;

public class Test {
	public static void main(String[] args) {
		/*************** ģ���ѯ���ݿ�Ľ�� ********************/
		City c1 = new City(1, "������");
		City c2 = new City(2, "������");
		City c3 = new City(3, "��ԭ��");
		City c4 = new City(4, "��ƽ��");
		City c5 = new City(5, "ͨ����");

		List<City> cities = new ArrayList<City>();
		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		cities.add(c4);
		cities.add(c5);

		Province p = new Province(1, "����ʡ", cities);
		/*************** ģ���ѯ���ݿ�Ľ�� ********************/
		/*************** ��ν���ת�� **************************/
		//1.����XStreamʵ������
		XStream xStream = new XStream();
		
		
		/*
		 * 2.Ϊxml��ʽ�ı�ǩ���ñ���
		 * alias(String name, Class type)
		 * 		* name:��ʾ����
		 * 		* type:ָ��ҪΪ�ĸ�JavaBean�����
		 */
		xStream.alias("province", Province.class);
		xStream.alias("city", City.class);
		
		/*
		 * 3.Ϊxml��ʽ�ı�ǩ��������
		 * useAttributeFor(Class definedIn, String fieldName)
		 * 		* definedIn:ָ��ҪΪ�ĸ�JavaBean��������
		 * 		* fieldName:ָ��Ҫ�����ĸ�����
		 */
		xStream.useAttributeFor(Province.class, "id");
		xStream.useAttributeFor(Province.class, "name");
		
		xStream.useAttributeFor(City.class, "id");
		xStream.useAttributeFor(City.class, "name");
		
		//4.ֱ�ӽ���ת��XML
		String xml = xStream.toXML(p);
		
		//����
		System.out.println(xml);
		
	}
}
