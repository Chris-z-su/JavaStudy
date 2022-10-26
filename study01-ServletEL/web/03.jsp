<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.bjsxt.pojo.Person"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '03.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br>-----------获取普通Java对象中的数据---------------<br>
  	<%
  		Person p = new Person();
  		pageContext.setAttribute("p", p, PageContext.APPLICATION_SCOPE);
  		
  	%>
  	<span>姓名：${p.name }=${p['name'] }=${p["name"] }</span><br/>
  	<span>类型：${p.class }</span><br/>
  	<%-- 
  		原理：
  			Person p = (Person)pageContext.findAttribute("p");
  			out.write(p.getName());
  	 --%>
  	<span>省份：${p.address.province }</span><br/>
  	
  	<br>-----------获取List中的数据---------------<br>
  	 <%
  	 	List list = new ArrayList();
  	 	list.add("aa");
  	 	list.add("bb");
  	 	list.add("cc");
  	 	
  	 	pageContext.setAttribute("list", list);
  	 %>
  	 <span>list:${list }</span>
  	 <br>
  	<span>取list中的第2个元素：${list[1] }</span>
  	 
  	<br>-----------获取Map中的数据---------------<br>
  	 <%
  	 	Map map = new HashMap();
  	 	map.put("a", "aaa");
  	 	map.put("b", "bbb");
  	 	map.put("c", "ccc");
  	 	
  	 	pageContext.setAttribute("map", map);
  	 %>
  	 <span>Map中的元素：${map.a }</span>
  </body>
</html>
