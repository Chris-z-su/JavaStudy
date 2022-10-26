<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sxt.pojo.Emp"%>
<%@ page import="com.sxt.pojo.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		span{color:red;font-size:30px;}
		table,tr,td{
			border:1px solid #ccc;
			border-collapse: collapse;
		}
		table{text-align:center;margin:0 auto;}
		tr{height:30px;}
		td{width:100px;}
	</style>
  </head>
  
  <body>
  	<%
  		String uname = (String)request.getAttribute("uname");
  	%>
  		<h4>欢迎<span><%=uname %></span>访问！</h4>
  		
  		<table>
  		<tr>
  			<td>ID</td><td>用户名</td><td>职位</td><td>上级ID</td><td>入职日期</td><td>工资</td><td>奖金</td><td>部门编号</td>
  		</tr>
  	<%
  		List<Emp> list = (List)request.getAttribute("emp");
  	
  		if(list != null){
  			for(Emp emp:list){
  	%>
  		<tr>
  			<td><%=emp.getEmpno() %></td>
  			<td><%=emp.getEname() %></td>
  			<td><%=emp.getJob() %></td>
  			<td><%=emp.getMgr() %></td>
  			<td><%=emp.getHiredate() %></td>
  			<td><%=emp.getSal() %></td>
  			<td><%=emp.getComm() %></td>
  			<td><%=emp.getDeptno() %></td>
  		</tr>
  	<%
  			}
  		}
  	 %>
  	</table>
  </body>
</html>
