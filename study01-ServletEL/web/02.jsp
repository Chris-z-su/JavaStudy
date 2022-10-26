<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '02.jsp' starting page</title>
    
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
  	<%--
  		Object obj1 = pageContext.getAttribute("user");
  		out.print(obj1);
  		out.print("<br/>");
  		
  		Object obj2 = request.getAttribute("user");
  		out.print(obj2);
  		out.print("<br/>");
  		
  		Object obj3 = session.getAttribute("user");
  		out.print(obj3);
  		out.print("<br/>");
  		
  		Object obj4 = application.getAttribute("user");
  		out.print(obj4);
  		out.print("<br/>");
  	 --%>
  	 <%=pageContext.findAttribute("user") %>
  </body>
</html>
