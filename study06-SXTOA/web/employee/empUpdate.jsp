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
    
    <title>My JSP 'empUpdate.jsp' starting page</title>
    
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
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
			
		});
		</script>
	</head>

	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">修改员工信息</a></li>
			</ul>
		</div>
		<div class="formbody">
			<div class="formtitle"><span>基本信息</span></div>
			<form method="post" action="employeeServlet.bjsxt?method=updateemp">
				<ul class="forminfo">
					<li>
						<label>用户名</label>
						<input name="empid" type="text" class="dfinput" value="${employee.empid }" /><i>必须唯一，也可以根据真实姓名自动生成</i>
					</li>
					<li>
						<label>真实姓名</label>
						<input name="realname" type="text" class="dfinput" value="${employee.realname }"/><i></i>
					</li>
					<li>
						<label>性别</label>
						<c:if test="${employee.sex==null }">
							<cite>
								<input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="sex" type="radio" value="女" />女<i>也可以根据身份证号自动获取</i>
							</cite>
						</c:if>
						<c:if test="${employee.sex=='男' }">
							<cite>
								<input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="sex" type="radio" value="女" />女<i>也可以根据身份证号自动获取</i>
							</cite>
						</c:if>
						<c:if test="${employee.sex=='女' }">
							<cite>
								<input name="sex" type="radio" value="男" />男&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="sex" type="radio" value="女" checked="checked" />女<i>也可以根据身份证号自动获取</i>
							</cite>
						</c:if>
					</li>
					<li>
						<label>出生日期</label>
						<input name="birthdate" type="text" class="dfinput" value='<fmt:formatDate value="${employee.birthdate }" pattern="yyyy-MM-dd"/>' onfocus="WdatePicker()" /><i>也可以根据身份证号自动获取</i>
					</li>
					<li>
						<label>入职时间</label>
						<input name="hiredate" type="text" class="dfinput" value='<fmt:formatDate value="${employee.hiredate }" pattern="yyyy-MM-dd"/>' onfocus="WdatePicker()"  /><i></i>
					</li>
						
					<li>
						<label>离职时间</label>
						<input name="leavedate" type="text" class="dfinput" value='<fmt:formatDate value="${employee.leavedate }" pattern="yyyy-MM-dd"/>' onfocus="WdatePicker()" /><i></i>
					</li>
					<li>
						<label>是否在职</label>
						<c:if test="${employee.onduty==1 }">
							<cite>
								<input name="onduty" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="onduty" type="radio" value="0" />否
							</cite>
						</c:if>
						<c:if test="${employee.onduty==0 }">
							<cite>
								<input name="onduty" type="radio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="onduty" type="radio" value="0" checked="checked" />否
							</cite>
						</c:if>
					</li>
					<li>
						<label>所属部门<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="deptno">
								<c:forEach var="dept" items="${deptList }">
									<option value="${dept.deptno }">${dept.deptname }</option>
								</c:forEach>
							</select>
						</div>
					</li>
					<li>
						<label>从事岗位<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="posid">
								<c:forEach var="position" items="${positionList }">
									<option value="${position.posid }" >${position.pname }</option>
								</c:forEach>
							</select>
						</div>
					</li>
					<li>
						<label>直接上级<b>*</b></label>						
						<div class="vocation">
							<select class="select1" name="mgrid">
								<c:forEach var="mgremp" items="${mgrList }" >
									<option value="${mgremp.empid }">${mgremp.realname }</option>
								</c:forEach>
							</select>							
						</div>
						&nbsp;&nbsp;<input name="" type="text" class="dfinput" placeholder="也可以在此输入首字母帮助显示"/>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" value="${employee.phone }" />
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput" value="${employee.qq }" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emercontactperson" cols="" rows="" class="textinput">${employee.emercontactperson }</textarea>
					</li>
					<li>
						<label>身份证号</label>
						<input name="idcard" type="text" class="dfinput" value="${employee.idcard }" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="submit" class="btn" value="确认保存" />
					</li>
				</ul>
			</form>
		</div>
	</body>
</html>