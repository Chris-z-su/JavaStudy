<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empList.jsp' starting page</title>
    
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
			//修改员工信息
			function updateemp(empid){
				window.location.href = "employeeServlet.bjsxt?method=querybyempid&empid="+empid;
			}
			
			//删除员工信息
			function deleteemp(empid){
				var flag = window.confirm("是否确认删除？");
				if(flag){
					window.location.href = "employeeServlet.bjsxt?method=deleteemp&empid="+empid;
				}
			}
			
			//查询员工信息
			function selectempbyempid(empid){
				window.location.href="employeeServlet.bjsxt?method=selectbyempid&empid="+empid;
			}
		
			//重置密码
			function resetpwd(empid){
				var flag = window.confirm("是否确认重置密码？");
				if(flag){
					window.location.href = "userServlet.bjsxt?method=resetpwd&empid="+empid;
				}
			}
		
		</script>
	</head>

	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">员工管理</a></li>
			</ul>
		</div>

		<div class="rightinfo">
			<form method="post" action="employeeServlet.bjsxt?method=argsfindemp">
			<ul class="prosearch">
				<li>
					<label>查询：</label><i>用户名</i>
					<a>
						<input name="empid" type="text" class="scinput" />
					</a><i>所属部门</i>
					<a>
						<select name="deptno" class="select1">
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptno }">${dept.deptname }</option>
							</c:forEach>
						</select>
					</a>
								
				</li>
				<li>
					<label>是否在职：</label>
					<input name="onduty" type="radio" value="1" checked="checked" />&nbsp;是&nbsp;&nbsp;
					<input name="onduty" type="radio" value="0" />&nbsp;否				
				</li>
				<li>
					<label>入职时间：</label>
					<a>
						<input name="hiredate" type="text" onclick="WdatePicker()" class="scinput" />
					</a>		
				</li>
					<a>
						<input type="submit" class="sure" value="查询" />
					</a>
			</ul>
			</form>
			<div>${info }</div>
			<div class="formtitle1"><span>员工列表</span></div>
			
			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>用户名<i class="sort"><img src="images/px.gif" /></i></th>
						<th>真实姓名</th>
						<th>所属部门</th>
						<th>所属岗位</th>
						<th>在职状态</th>
						<th>入职时间</th>
						<th>离职时间</th>
						<th>联系方式</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="employee" items="${employeeList }">
					<tr>
						<td>
							<input name="" type="checkbox" value="" />
						</td>
						<td>${employee.empid }</td>
						<td>${employee.realname }</td>
						<td>${employee.dept.deptname }</td>
						<td>${employee.position.pname }</td>
						<c:if test="${employee.onduty == 1 }"><td>在职</td></c:if>
						<c:if test="${employee.onduty == 0 }"><td>离职</td></c:if>
						<td>${employee.hiredate }</td>
						<td>${employee.leavedate }</td>
						<td>${employee.phone }</td>
						<td>
							<a href="javascript:void(0)" class="tablelink" onclick="selectempbyempid('${employee.empid }')">查看</a> 
							<a href="javascript:void(0)" class="tablelink" onclick="updateemp('${employee.empid }')">修改</a> 
							<a href="javascript:void(0)" class="tablelink" onclick="deleteemp('${employee.empid }')"> 删除</a>
							<a href="javascript:void(0)" class="tablelink" onclick="resetpwd('${employee.empid }')"> 重置密码</a>
						</td>
					</tr>

				</c:forEach>
				</tbody>
			</table>

			<div class="pagin">
				<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
				<ul class="paginList">
					<li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
					<li class="paginItem"><a href="javascript:;">1</a></li>
					<li class="paginItem current"><a href="javascript:;">2</a></li>
					<li class="paginItem"><a href="javascript:;">3</a></li>
					<li class="paginItem"><a href="javascript:;">4</a></li>
					<li class="paginItem"><a href="javascript:;">5</a></li>
					<li class="paginItem more"><a href="javascript:;">...</a></li>
					<li class="paginItem"><a href="javascript:;">10</a></li>
					<li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
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