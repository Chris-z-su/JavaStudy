<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sxt.pojo.Employee"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(function(){	
				//导航切换
				$(".menuson .header").click(function(){
					var $parent = $(this).parent();
					$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
					
					$parent.addClass("active");
					if(!!$(this).next('.sub-menus').size()){
						if($parent.hasClass("open")){
							$parent.removeClass("open").find('.sub-menus').hide();
						}else{
							$parent.addClass("open").find('.sub-menus').show();	
						}
						
						
					}
				});
				
				// 三级菜单点击
				$('.sub-menus li').click(function(e) {
			        $(".sub-menus li.active").removeClass("active");
					$(this).addClass("active");
			    });
				
				$('.title').click(function(){
					var $ul = $(this).next('ul');
					$('dd').find('.menuson').slideUp();
					if($ul.is(':visible')){
						$(this).next('.menuson').slideUp();
					}else{
						$(this).next('.menuson').slideDown();
					}
				});
			});
		</script>
		
		<script type="text/javascript">
			/* $(function(){
				$.ajax({
	                success:function(emp){//rsData 服务器返回给客户端的数据
	                                        //和  dataType 有关； 和servlet  返回的MIME类型有关
	                    console.log("emp:"+emp.emptype);
	                }
	        	});
			}); */
		</script>
	</head>

	<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>导航菜单</div>

		<dl class="leftmenu">
		
		<!-- 1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员 -->
		<c:if test="${emp.emptype==2 || emp.emptype==3 }">
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>人事管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="dept/deptAdd.jsp" target="rightFrame">添加部门</a><i></i></li>
					<li><cite></cite><a href="deptServlet.bjsxt?method=finddept" target="rightFrame">部门管理</a><i></i></li>
					<li><cite></cite><a href="position/positionAdd.jsp" target="rightFrame">添加岗位</a><i></i></li>
					<li><cite></cite><a href="positionServlet.bjsxt?method=findposition" target="rightFrame">岗位管理</a><i></i></li>
					<li><cite></cite><a href="employeeServlet.bjsxt?method=addemp" target="rightFrame">添加员工</a><i></i></li>
					<li><cite></cite><a href="employeeServlet.bjsxt?method=findemp" target="rightFrame">员工管理</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>考勤管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="duty/dutyAdd.jsp" target="rightFrame">签到签退</a><i></i></li>
					<li><cite></cite><a href="dutyServlet.bjsxt?method=queryallsign" target="rightFrame">考勤管理</a><i></i></li>
					<li><cite></cite><a href="myDuty.html" target="rightFrame">我的考勤</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>报销管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="expenseAdd.html" target="rightFrame">添加报销</a><i></i></li>
					<li><cite></cite><a href="toAudit.html" target="rightFrame">待审报销</a><i></i></li>
					<li><cite></cite><a href="myExpense.html" target="rightFrame">我的报销</a><i></i></li>
					<li><cite></cite><a href="myAudit.html" target="rightFrame">我的审核历史</a><i></i></li>					
				</ul>
			</dd>
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>收支管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="incomeAdd.html" target="rightFrame">添加收入</a><i></i></li>
					<li><cite></cite><a href="incomeList.html" target="rightFrame">查看收入</a><i></i></li>
					<li><cite></cite><a href="incomestatis.html" target="rightFrame">收入统计</a><i></i></li>
					<li><cite></cite><a href="expenseList.html" target="rightFrame">查看支出</a><i></i></li>
					<li><cite></cite><a href="expensestatis.html" target="rightFrame">支出统计</a><i></i></li>
				</ul>
			</dd>
		
		</c:if>
		
		<c:if test="${emp.emptype==1 }">
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>考勤管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="duty/dutyAdd.jsp" target="rightFrame">签到签退</a><i></i></li>
					<li><cite></cite><a href="myDuty.html" target="rightFrame">我的考勤</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>报销管理</div>
				<ul class="menuson">
					<li><cite></cite><a href="expenseAdd.html" target="rightFrame">添加报销</a><i></i></li>
					<li><cite></cite><a href="myExpense.html" target="rightFrame">我的报销</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		
		<!-- 普通权限 -->
			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>个人平台</div>
				<ul class="menuson">
					<li><cite></cite><a href="myInfo.html" target="rightFrame">我的信息</a><i></i></li>
					<li><cite></cite><a href="info/myPwd.jsp" target="rightFrame">修改密码</a><i></i></li>
				</ul>
			</dd>
		</dl>

	</body>

</html>