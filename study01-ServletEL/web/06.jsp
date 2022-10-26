<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="utf-8"%>
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
  	<h2>EL表达式输出</h2>
  	<label>常量输出：</label>${10 }<br/>
  	<label>四则运算：</label>${10+2 }，${10-2 }，${10*2 }，${10/2 }，${10%3 }<br/>
  	<label>等于：</label>${10==10 }，${10 eq 10 }<br/>
  	<%-- <label>不等于：</label>${10!=2 }，${10 ne 2 }<br/> --%>
  	<label>取余：</label>${10%3 }，${10 mod 3 }<br/>
  	<hr>
  	<label>判空：</label>${empty "" }<br/>
  	<label>非空判断：</label>${empty not "" }<br/>
  </body>
</html>
