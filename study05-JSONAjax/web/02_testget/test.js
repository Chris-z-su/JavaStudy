window.onload = function() {
	document.getElementById("ok").onclick = function(){
		//1.获取XHRHttpRequest对象
		var xhr = ajaxFunction();
		
		/*
		 *  2.注册监听
		 *  readyState 属性表示Ajax请求的当前状态。它的值用数字代表。
				0 代表未初始化。 还没有调用 open 方法
				1 代表正在加载。 open 方法已被调用，但 send 方法还没有被调用
				2 代表已加载完毕。send 已被调用。请求已经开始
				3 代表交互中。服务器正在发送响应
				4 代表完成。响应发送完毕
				
				注意:理论上永远得不到.
		 */
		xhr.onreadystatechange = function() {
			alert(xhr.readyState);
			if(xhr.readyState == 4){
				if(xhr.status == 200 || xhr.status == 304){
					var data = xhr.responseText;
					alert(data);
				}
			}
		};
		
		//3.客户端与服务器端建立连接
		xhr.open("post", "testServlet?timeStamp="+new Date().getTime(), true);
		
		//如果请求方式是POST，需要设置请求首部信息
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		
		//4.客户端向服务器端发送请求
		xhr.send("a=7&b=8");
		/*
		 * send()方法与请求类型没有关系?存在关系
		 * 	* 如果请求类型是GET方式的话,send()方法发送的请求数据,服务器端接收不到
		 * 		* 该步骤不能被省略,改写为:xhr.send(null);
		 * 	* 如果请求类型是POST方式的,send()方法发送的请求数据,服务器端可以接收
		 * 		* 必须要设置请求首部信息:"Content-Type"为"application/x-www-form-urlencoded"
		 */
	};
	
	/**
	 * 获取XMLHttpRequest对象的固定写法
	 * 
	 * 源码路径：
	 * 		F:\BaiduNetdiskDownload\day31Ajax&JSON
	 * 				\day31Ajax&JSON\第三十一天Ajax&JSON\Day30_AjAX上午
	 * 				\资料\02_Ajax\获取XMLHttpRequest对象.txt
	 */
	function ajaxFunction() {
		var xmlHttp = null;
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
	}
};