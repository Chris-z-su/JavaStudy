<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sxt.domain.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSTL的Core标签详解</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		/* tr:nth-child(2n){
			background-color: #fbc9a7;
		} */
		.odd{
			background-color: #c3f3c3;
		}
		.even{
			background-color: #f3c3f3;
		}
	</style>
  </head>
  
  <body>
  	<br/>-------------------c:forEach 遍历数据----------------------<br/>
  	<br/>
  	<%
  		List students = new ArrayList();
  		students.add(new Student("王思聪","男","北京",30));
  		students.add(new Student("刘诗诗","女","上海",28));
  		students.add(new Student("林发明","男","南宁",18));
  		students.add(new Student("黄聪聪","男","济南",17));
  		students.add(new Student("王赵廷","男","济南",35));
  		pageContext.setAttribute("students", students);
  	%>
  	<table border="1">
  		<tr>
  			<th width="70px">索引</th>
  			<th width="70px">计数</th>
  			<th width="70px">第一条</th>
  			<th width="70px">最后一条</th>
  			<th width="80px">姓名</th>
  			<th width="60px">性别</th>
  			<th width="80px">地址</th>
  			<th width="60px">年龄</th>
  		</tr>
  		<!-- 
  			属性：varStatus	
  			作用： 给一个对象取一个名字。它所指向的对象记录着当前遍历的元素的一些信息。
  					该对象存放在page域范围中，有以下方法：
  						int getInder()：索引，从0开始
  						int getCount()：计数，从1开始
  						boolean isLast()：是否是最后一条记录
  						boolean isFirst	()：是否是第一条记录
  		
  		-->
  		<c:forEach items="${students }" var="s" varStatus="vs">
	  		<tr class="${vs.index%2==0?'odd':'even' }">
	  			<td>${vs.index }</td>
	  			<td>${vs.count }</td>
	  			<td>${vs.first }</td>
	  			<td>${vs.last }</td>
	  			<td>${s.name }</td>
	  			<td>${s.gender }</td>
	  			<td>${s.city }</td>
	  			<td>${s.age }</td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<br/>
  	<c:forEach begin="1" end="10" var="s">
  		${s }
  	</c:forEach>
  	<br/><br/>
  	<%
  		pageContext.setAttribute("strs", new String[]{"a","b","c","d","e","f"});
  	%>
  	<c:forEach items="${strs }" var="s" step="2">${s }</c:forEach><br/>
  	<c:forEach items="${strs }" var="s" begin="1" end="4">${s }</c:forEach><br/><!-- 含头也含尾 -->
  	<br/>
  	<hr/>
  	
  	<br/>------------c:forTokens 分割字符串后遍历-------------<br/>
  	<%
  		pageContext.setAttribute("s1", "2018-10/12");
  	%>
  	<c:forTokens items="${s1 }" delims="-/" var="s">
  		${s }<br/>
  	</c:forTokens>
  	
  	<br/>------------c:import 包含-------------<br/>
  	<!-- 动态包含 -->
  	<!-- 可以包含任何页面 -->
  	<c:import url="/4.jsp"></c:import>
  	<%-- <c:import url="http://localhost:8080"></c:import> --%>
  	
  	<br/>------------c:redirect 请求重定向-------------<br/>
  	<%-- <c:redirect url="4.jsp"></c:redirect> --%>
  	
  	<br/>
  	<br/>------------c:url 组织URL地址-------------<br/>
  	<c:url value="/4.jsp">
  		<c:param name="username" value="zzz"></c:param>
  		<c:param name="password" value="123"></c:param>
  	</c:url><br/>
  	<c:url value="/4.jsp" var="url" scope="page"></c:url><br/>
  	<a href="${url }">点击一下</a>
  	
  	
  </body>
</html>
