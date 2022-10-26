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
  </head>
  
  <body>
  	<br>-------------------c:out 输出内容到页面上----------------------<br>
  	<%
  		pageContext.setAttribute("s1", "cgx");
  		pageContext.setAttribute("s2", "<h2>zxt</h2>");
  	%>
  	${s1 }<br>
  	<c:out value="${s2 }" escapeXml="true"></c:out><br>
  	<c:out value="${s2 }" escapeXml="false"></c:out><br>
  	<c:out value="${s3 }" default="木有"></c:out><br>
  	
  	<br>-------------------c:set 设置JavaBean的属性值----------------------<br>
  	<!-- 把某个值存放到指定的域范围中 -->
  	<c:set value="ppp" var="p" scope="page"></c:set>
  	${pageScope.p }<br>
  	<!-- 设置JavaBean的属性值 -->
  	<%
  		pageContext.setAttribute("s4", new Student("张三"));
  	%>
  	${s4.name }<br/>
  	<c:set value="思思" property="name" target="${s4 }"></c:set>
  	${s4.name }<br/>
  	<!-- 设置Map的key和value -->
  	<%
  		Map map = new HashMap();
  		pageContext.setAttribute("map", map);
  	%>
  	<c:set value="vivo" property="keyName" target="${map }"></c:set>
  	${map.keyName }
  	
  	<br>-------------------c:remove 从指定范围中删除数据，没有指定范围删除所有----------------------<br>
  	<%
  		pageContext.setAttribute("s5", "pageS5");
		request.setAttribute("s5", "requests5");
  	%>
  	page:${pageScope.s5 }<br/>
  	request:${requestScope.s5 }<br/>
  	<c:remove var="s5" scope="page"/>
  	page:${pageScope.s5 }<br/>
  	request:${requestScope.s5 }<br/>
  	
  	<br>-------------------c:catch 相当于Java中的catch代码块----------------------<br>
  	<c:catch var="e">
	  	${s4.gender }
  	</c:catch>
  	异常详细信息：${e.message }<br/>
  	
  	<br>-------------------c:if 相当于Java中的if语句----------------------<br>
  	<c:if test="true">妲己</c:if><br/>
  	<c:if test="false">伽罗</c:if><br/>
  	<c:if test="${1>0 }" var="result" scope="page">安琪拉</c:if><br/>
  	${pageScope.result }<br/><!-- result:记录表达式结果，方便以后调用 -->
  	
  	<br>-------------------c:choose c:when c:otherwise 类似Java中的if-else if----------------------<br>
  	<%
  		pageContext.setAttribute("grade", "D");
  	%>
  	<c:choose>
  		<c:when test="${grade=='A' }">优秀</c:when>
  		<c:when test="${grade=='B' }">良好</c:when>
  		<c:when test="${grade=='C' }">及格</c:when>
  		<c:otherwise>尚需努力</c:otherwise>
  	</c:choose>
  	<br/>
  </body>
</html>
