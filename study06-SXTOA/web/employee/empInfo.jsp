<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
			    $(".select1").uedSelect({
					width : 345			  
				});
				
			});
			$(function(){
				$("#backlist").click(function(){
					window.location.href = "employeeServlet.bjsxt?method=findemp";
				});
			});
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">员工信息详情</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<label>${employee.empid }</label>
				</li>
				<li>
					<label>密码</label>
					<label>${employee.password }</label>
				</li>
				<li>
					<label>真实姓名</label>
					<label>${employee.realname }</label>
				</li>
				<li>
					<label>性别</label>
					<label>${employee.sex }</label>						
				</li>
				<li>
					<label>出生日期</label>
					<label><fmt:formatDate value="${employee.birthdate }" pattern="yyyy-MM-dd"/></label>
				</li>
				<li>
					<label>入职时间</label>
					<label><fmt:formatDate value="${employee.hiredate }" pattern="yyyy-MM-dd"/></label>
				</li>
				
				<li>
					<label>离职时间</label>
					<label><fmt:formatDate value="${employee.leavedate }" pattern="yyyy-MM-dd"/></label>
				</li>
				<li>
					<label>是否在职</label>
					<label>
						<c:if test="${employee.onduty == 1 }">在职</c:if>
						<c:if test="${employee.onduty == 0 }">离职</c:if>
					</label>
				</li>
				<li>
					<label>所属部门<b>*</b></label>
					<label>${employee.dept.deptname }</label>

				</li>
				<li>
					<label>直接上级<b>*</b></label>						
					<label>${mgremp.realname }</label>	
				</li>
				<li>
					<label>联系方式</label>
					<label>${employee.phone }</label>
				</li>
				<li>
					<label>QQ号</label>
					<label>${employee.qq }</label>
				</li>
				<li>
					<label>紧急联系人信息</label>
					<label>${employee.emercontactperson }</label>
				</li>
				<li>
					<label>身份证号</label>
					<label>${employee.idcard }</label>
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" id="backlist" type="button" class="btn" value="返回" />
				</li>
			</ul>

		</div>

	</body>

</html>