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
    
    <title>实现循环遍历的功能：强版</title>
    
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
		List cart = new ArrayList();
		cart.add("《万历十五年》");
		cart.add("《查令十字街84号》");
		cart.add("《摆渡人》");
		pageContext.setAttribute("cart", cart);
	%>
	<sitheima:if test="${empty cart }">您没有购买任何商品！</sitheima:if>
	<sitheima:if test="${!empty cart }">
		<sitheima:forEach2 items="${cart }" var="c">
			${c }<br/>
		</sitheima:forEach2>
	</sitheima:if>
	
	<hr>
	<%
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		pageContext.setAttribute("set", set);
	%>
	<sitheima:forEach2 items="${set }" var="s">
		${s }<br>
	</sitheima:forEach2>
	
	<hr>
	<%
		Map map = new HashMap();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		pageContext.setAttribute("map", map);
	%>
	<sitheima:forEach2 items="${map }" var="me">
		${me.key }=${me.value }<br>
	</sitheima:forEach2>
	
	<hr>
	<%
		String ss[] = {"aaa","bbb","ccc"};
		pageContext.setAttribute("ss", ss);
	%>
	<sitheima:forEach2 items="${ss }" var="s">
		${s }<br>
	</sitheima:forEach2>
	
	<hr>
	<%
		int ii[] = {1,2,3};
		pageContext.setAttribute("ii", ii);
	%>
	<sitheima:forEach2 items="${ii }" var="i">
		${i }<br>
	</sitheima:forEach2>
  </body>
</html>
