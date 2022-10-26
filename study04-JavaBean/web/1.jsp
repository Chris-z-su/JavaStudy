<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSP中操作JavaBean的元素</title>
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
  	<jsp:useBean id="s1" class="com.sxt.domain.Student" scope="page"></jsp:useBean>
  	<%--
  		//模拟userbean的原理 
  		com.sxt.domain.Student s1 = null;
  		s1 = (com.sxt.domain.Student)pageContext.getAttribute("s1", PageContext.PAGE_SCOPE);
  		if(s1 == null){
  			s1 = new com.sxt.domain.Student();
  			pageContext.setAttribute("s1", s1);
  		}
  	 --%>
  	<!-- 测试 -->
  		<!-- 使用Java脚本 -->
  		<%=s1.getName() %><br>
  		<!-- 使用EL表达式 -->
  		姓名：${s1.name }<br><!-- 这里的name指的是方法getName()中的name，表示方法属性 -->
  		性别：${s1.gender }<br>
  		<!-- JavaBean获取方式 -->
  		<jsp:getProperty property="name" name="s1"/><br>
  		<jsp:getProperty property="gender" name="s1"/><br>
  		
  		<hr>
  		
  		<jsp:setProperty property="name" name="s1" value="小雪"/>
  		<jsp:setProperty property="gender" name="s1" value="女"/>
  		姓名：${s1.name }<br>
  		性别：${s1.gender }<br>
  		
  		<hr>
  		
  		<!-- 填充请求参数的值 -->
  		<jsp:setProperty property="name" name="s1" param="name"/>
  		<jsp:setProperty property="gender" name="s1" param="gender"/>
  		姓名：${s1.name }<br>
  		性别：${s1.gender }<br>
  		<!-- 规律：请求参数名和JavaBean的属性名一致。 -->
  		<jsp:setProperty property="*" name="s1"/>
  		姓名：${s1.name }<br>
  		性别：${s1.gender }<br>
  </body>
</html>
