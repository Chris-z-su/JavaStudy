<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<form action="user" method="get">
	  	<%
	  		String flag = (String)request.getAttribute("flag"); 
	  		if(flag == "loginFalse"){
	  	%>
	  	<b style="color:red">用户名或密码错误</b><br />
	  	<%	
	  		}
	  	%>
	  	<table>
	  		<tr>
	  			<td>用户名:</td>
	  			<td><input type="text" name="uname" value="" /></td>
	  		</tr>
	  		<tr>
	  			<td>密码:</td>
	  			<td><input type="password" name="pwd" value="" /></td>
	  		</tr>
	  		<tr>
	  			<td colspan="2"><input type="submit" name="" value="登录" /></td>
	  		</tr>
	  	</table>
	</form>
  </body>
</html>
