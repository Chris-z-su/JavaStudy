<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://wwww.shubaoz.top/smytaglib" prefix="sitheima" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>实现if判断的功能</title>
    
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
   	<sitheima:if test="true">
   		执行
   	</sitheima:if>
   	<sitheima:if test="${!false }">
   		不执行
   	</sitheima:if>
   	<%
   		List cart = new ArrayList();
   		cart.add("《我不》");
   		pageContext.setAttribute("cart", cart);
   	%>
	<sitheima:if test="${empty cart }">
		您未购买任何商品！
	</sitheima:if>   
	<sitheima:if test="${!empty cart }">
		您购买了很多商品！
	</sitheima:if>   
	
	<hr>
	<%
		session.setAttribute("user", "zzz");
	%>
	<sitheima:if test="${sessionScope.user == null }">
		<a href="#">登录</a>
	</sitheima:if>
	<sitheima:if test="${sessionScope.user != null }">
		欢迎您：${sessionScope.user }<a href="#">注销</a>
	</sitheima:if>
  </body>
</html>
