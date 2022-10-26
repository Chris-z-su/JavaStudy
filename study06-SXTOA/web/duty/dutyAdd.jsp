<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
	    
	    <title>My JSP 'dutyAdd.jsp' starting page</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript">
			//页面加载的时候，查询当前用户当天是否已签到
			//基于jQuery的Ajax
			$(function(){
				var flag = false;//签到状态，false：未签到，true：已签到
				$.ajax({
					url:"dutyServlet.bjsxt?method=findsign",
					data:"",
					dataType:"json",
					type:"post",
					success:function(rsData){
						console.log("签到的状态");
						console.log(rsData);
						
						if(rsData.code == 1){
							$("#signId").html(rsData.info);
							$("#signinid").attr('disabled',true).val("已签到");	
							flag = true;
						}else{
							$("#signId").html(rsData.info);		
							flag = false;
						}
					}
				});
				
				//执行签到操作Ajax请求
				//给签到按钮添加点击事件
				$("#signinid").click(function(){
					if(flag){
						alert("不能重复签到！");
					}else{
						//ajax请求
						$.ajax({
							url:"dutyServlet.bjsxt?method=signin",
							data:"",
							dataType:"json",
							type:"post",
							success:function(rsData){
								alert(rsData.info);
								if(rsData.code == 1){
									$("#signId").html(rsData.info);
									$("#signinid").attr('disabled',true).val("已签到");		
									flag = true;
								}else{
									$("#signId").html(rsData.info);		
									flag = false;
								}
							}
						});
					}
				});
				
				//给签退按钮添加点击事件
				$("#signoutid").click(function(){
					if(!flag){
						alert("未签到不能签退！");
					}else{
						//ajax请求
						$.ajax({
							url:"dutyServlet.bjsxt?method=signout",
							data:"",
							dataType:"json",
							type:"post",
							success:function(rsData){
								alert(rsData.info);
								if(rsData.code == 1){
									$("#signId").html(rsData.info);	
									$("#signoutid").attr('disabled',true).val("已签退");	
									flag = true;
								}else{
									$("#signId").html(rsData.info);		
									flag = false;
								}
							}
						});
					}
				});
				
				
			});
		
		</script>
	</head>
	
	<body>
	
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">考勤管理</a></li>
	    <li><a href="#">签到签退</a></li>
	    </ul>
	    </div>
	    
	    <div class="formbody">
	    
	    <div class="formtitle"><span>基本信息</span></div>
	    	<div id="signId"></div>
		    <ul class="forminfo">
		    	<li>
		    		<label>&nbsp;</label>
		    		<input name="" id="signinid" type="button" class="btn" value="签到"/> 每天签到一次，不可重复签到
		    	</li>
		        <li><label>&nbsp;</label></li>
		    	<li><label>&nbsp;</label></li>
		      	<li>
			      	<label>&nbsp;</label>
			      	<input name="" id="signoutid" type="button" class="btn" value="签退"/>可重复签退，以最后一次签退为准
		      	</li>
		    </ul>
	    </div>
	
	</body>

</html>

