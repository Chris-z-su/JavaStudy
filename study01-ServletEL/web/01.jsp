<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '01.jsp' starting page</title>
    
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
  	<%
  		pageContext.setAttribute("user", "pp");//页面范围存放数据
  		//pageContext.setAttribute("user", "zhangsan", PageContext.PAGE_SCOPE);//等价
  		
  		request.setAttribute("user", "rp");//请求范围数据
  		//pageContext.setAttribute("user", "lisi", PageContext.REQUEST_SCOPE);//等价
  		
  		session.setAttribute("user", "sp");//会话范围数据
  		//pageContext.setAttribute("user", "sp", PageContext.SESSION_SCOPE);//等价
  		
  		application.setAttribute("user", "ap");//应用范围
  		//pageContext.setAttribute("user", "ap", PageContext.APPLICATION_SCOPE);//等价
  		
  		//重定向
  		//response.sendRedirect(request.getContextPath()+"/02.jsp");
  		
  	 %>
  	 <!-- 转发 -->
  	 <jsp:forward page="/02.jsp"></jsp:forward>
  	 
  </body>
</html>
