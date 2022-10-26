/**
 * 
 */
window.onload = function() {
	document.getElementById("checkusername").onclick = function() {
		//获取用户名
		var username = document.getElementById("username").value;

		//获取XHTHttpRequest对象
		var xhr = ajaxFunction();
		
		//注册监听
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				if(xhr.status == 200 || xhr.status == 304){
					var data = xhr.responseText;
					//获取所要操作的div标签
					document.getElementById("divcheck").innerHTML = data;
					
				}
			}
		};
		
		xhr.open("post", "../registerServlet?timeStamp="+new Date().getTime(), true);
		//设置请求首部信息
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		
		xhr.send("username="+username);
		
	};

	function ajaxFunction() {
		var xmlHttp=null;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	};
};