<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '04.jsp' starting page</title>
    
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
  		pageContext.setAttribute("p", "pp", PageContext.PAGE_SCOPE);
  		pageContext.setAttribute("p", "rp", PageContext.REQUEST_SCOPE);
  		pageContext.setAttribute("p", "sp", PageContext.SESSION_SCOPE);
  		pageContext.setAttribute("p", "ap", PageContext.APPLICATION_SCOPE);
  		//application.setAttribute("p", "ap");//与上等价
  		
  		//取值
  		out.write(application.getAttribute("p").toString());//ap
  		out.write(pageContext.findAttribute("p").toString());//pp	从小到大查找
  		
  		//转发
  		RequestDispatcher rd = request.getRequestDispatcher("/01.jsp");
  		rd.forward(request, response);
  		//pageContext.forward("/01.jsp");
  	%>
  </body>
</html>
