<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">个人信息</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    
    <form method="post" action="userServlet.bjsxt?method=updatepwd">
   		<ul>${error }</ul>
	    <ul class="forminfo">
	    <li><label>旧密码</label><input name="oldpwd" type="password" class="dfinput" /><i></i></li>
	    <li><label>新密码</label><input name="newpwd" type="password" class="dfinput" /><i></i></li>
	    <li><label>新确认密码</label><input name="confirmpwd" type="password" class="dfinput" /></li>
	    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认修改"/></li>
	    </ul>
    </form>
    
    </div>


</body>

</html>

