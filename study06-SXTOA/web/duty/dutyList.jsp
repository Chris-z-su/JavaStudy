<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dutyList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
				width : 200		  
			});
			
		});
		</script>
		<script type="text/javascript">
			$(document).ready(function(){
			  $(".click").click(function(){
			  $(".tip").fadeIn(200);
			  });
			  
			  $(".tiptop a").click(function(){
			  $(".tip").fadeOut(200);
			});
			
			  $(".sure").click(function(){
			  $(".tip").fadeOut(100);
			});
			
			  $(".cancel").click(function(){
			  $(".tip").fadeOut(100);
			});
			
			});
		</script>
		<script type="text/javascript">
			$(function(){
				$("#searchId").click(function(){
					var empid = $("#empid").val();
					var deptno = $("#deptno").val();
					var dtdate = $("#dtdate").val();
					window.location.href = "dutyServlet.bjsxt?method=queryallsignargs&empid="+ empid + "&deptno=" + deptno + "&dtdate=" + dtdate;
				});
			})
			
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">考勤管理</a></li>
				<li><a href="#">考勤管理</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<ul class="prosearch">
				<li>
					<label>查询：</label>
					<i>用户名</i>
					<a>
						<input name="empid" id="empid" type="text" class="scinput" />
					</a><i>所属部门</i>
					<a>
						<select class="select1" name="deptno" id="deptno">
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptno }">${dept.deptname }</option>
							</c:forEach>
						</select>
					</a>
					<i>考勤时间</i>
					<a>
						<input name="dtdate" id="dtdate" type="text" class="scinput" onfocus="WdatePicker()" />
					</a>	
					<a>
						<input name="" id="searchId" type="button" class="sure" value="查询" />
						
					</a>
					<a>
						 <input name="" type="button" class="scbtn2" value="导出"/>
						
					</a>
					
				</li>
				
					
			</ul>

			<div class="formtitle1"><span>考勤管理</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>用户名<i class="sort"><img src="images/px.gif" /></i></th>
						<th>真实姓名</th>
						<th>所属部门</th>
						<th>出勤日期</th>
						<th>签到时间</th>
						<th>签退时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="duty" items="${dutyEmpList }">
						<tr>
							<td>
								<input name="" type="checkbox" value="" />
							</td>
							<td>${duty.empid }</td>
							<td>${duty.realname }</td>
							<td>${duty.deptname }</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd" value="${duty.dtdate }" /> 
							</td>
							<td>${duty.signintime }</td>
							<td>${duty.signouttime }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="pagin">
				<div class="message">共<i class="blue">${pageUtil.rowcount }</i>条记录，当前显示第&nbsp;<i class="blue">${pageUtil.currnav }&nbsp;</i>页</div>
				<ul class="paginList">
					<li class="paginItem">
						<a href="dutyServlet.bjsxt?method=queryallsign&currnav=${pageUtil.prev }">  
							<span class="pagepre"></span>
						</a>
					</li>
					<!-- <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li> -->
					
					<c:forEach var="i" begin="${pageUtil.begin }" end="${pageUtil.end }">
						<li class="paginItem"><a href="javascript:;">${i }</a></li>
					</c:forEach>
					
					<!-- <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li> -->
					<li class="paginItem">
						<a href="dutyServlet.bjsxt?method=queryallsign&currnav=${pageUtil.next }">  
							<span class="pagenxt"></span>
						</a>
					</li>
				</ul>
			</div>

			<div class="tip">
				<div class="tiptop"><span>提示信息</span>
					<a></a>
				</div>

				<div class="tipinfo">
					<span><img src="images/ticon.png" /></span>
					<div class="tipright">
						<p>是否确认对信息的修改 ？</p>
						<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp;
					<input name="" type="button" class="cancel" value="取消" />
				</div>

			</div>

		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>