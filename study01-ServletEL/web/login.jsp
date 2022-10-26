<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  	<form action="login.jsp">
  		账号：<input type="text" name="username" /><br/>
  		密码：<input type="password" name="password" /><br/>
  		<input type="submit" value="登录" />
  	</form>
  	<hr>
  	<%
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		
  		response.addCookie(new Cookie("personName","aaa"));
  	%>
  	<h3><%=username %></h3>
  	<h3><%=password %></h3>
  	<hr>
  	
	<h2>单值接收</h2>
  	<h3>${param.username }</h3>
  	<h3>${param.password }</h3>

	<hr>

	<h2>多值接收</h2>
  	<h3>${paramValues.favor[0] }，${paramValues.favor[1] }</h3>
  	
  	<hr>
  	
  	<h2>头信息的接收</h2>
  	<h3>${header.Host }</h3>
  	
  	<hr>
  	
  	<h2>servletContext的级别参数获取</h2>
  	<h3>${initParam.person_name }</h3>
  	
  	<hr>
  	
  	<h2>cookie的使用</h2>
  	<h3>${cookie.personName.name }:${cookie.personName.value }</h3>
  </body>
</html>
