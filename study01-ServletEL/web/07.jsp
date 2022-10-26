<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL隐式对象</title>
    
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
  	${pageContext }<br>
  	<%=request.getContextPath() %><br>
  	${pageContext.request.contextPath }<br>
  	<%
  	session.setAttribute("p", "pp");
  	%>
  	1.${p }<br/><!-- 从四大范围依次搜索 -->
  	2.${pageScope.p }<br/><!-- 专门从页面范围中取名称为p的value值 -->
  	3.${sessionScope.p }<br/>
  	${sessionScope }<br/>
  	
  	<hr>
  	${param.username }<br/>
  	${paramValues.password[1] }<br/>
  	
  	${header['Accept-Encoding'] }
  	
  	<hr>
  	${initParam.encoding }<br>
  	
  	${cookie.JSESSIONID }<br/>
  	${cookie.JSESSIONID.name }<br/>
  	${cookie.JSESSIONID.value }<br/>
  </body>
</html>
