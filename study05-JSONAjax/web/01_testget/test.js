/**
 * 当页面内容加载完毕之后，再执行以下代码
 */
window.onload = function() {
	document.getElementById("ok").onclick = function(){
		// 实现Ajax异步交互,与页面的表单没有关系(不可能有关系)
		//alert("111");
		/*
		 * 1.创建XMLHttpRequest对象：属性和方法
		 */
		var xhr = ajaxFunction();
		
		/*
		 * 2. 客户端与服务器建立连接
		 * 利用XMLHttpRequest对象的open(method, url, asynch, username, password)方法
		 * 		* method:请求类型,GET或POST.
		 * 		* url:请求路径,可以是相对路径或绝对路径.
		 * 		* asynch:表示是否异步,true(默认值)表示异步,false表示同步
		 * 		* username, password:服务器 http认证的用户名和密码，一般不指定
		 */
		//timeStamp:表示时间戳，用于IE浏览器第二次未响应的情况
		xhr.open("GET", "testServlet?timeStamp="+new Date().getTime()+"&c=9", true);

		/*
		 * 3.客户端向服务器端发送请求
		 * 利用XMLHttpRequest对象的send()方法
		 * 		如果请求类型是GET方式的话,send()方法发送请求数据,服务器端接收不到
		 * 		该步骤不能被省略,以下内容可以改写为:xhr.send(null);
		 */
		xhr.send("a=7&b=8");

		/*
		 * 4.服务器端向客户端进行响应
		 * 利用XMLHttpRequest对象的onreadystatechange属性:用于监听服务器端的状态
		 * 		readyState:表示Ajax请求的当前状态。它的值用数字代表。
					0 代表未初始化。 还没有调用 open 方法
					1 代表正在加载。 open 方法已被调用，但 send 方法还没有被调用
					2 代表已加载完毕。send 已被调用。请求已经开始
					3 代表交互中。服务器正在发送响应
					4 代表完成。响应发送完毕
				status:	常用状态码及其含义：
					404 没找到页面(not found)
					403 禁止访问(forbidden)
					500 内部服务器出错(internal service error)
					200 一切正常(ok)
					304 没有被修改(not modified)(服务器返回304状态，表示源文件没有被修改 )
		 * 
		 */
		//onreadystatechange：当xmlhttpRequest对象的readystate状态发送改变的时候，触发此函数
		xhr.onreadystatechange = function(){
			//接收服务器端的通信状态
			//alert(xhr.readyState);		//2,3,4一共三个状态,只关注4的状态
			//alert(xhr.status);//状态码
			//数据接收完成
			if(xhr.readyState == 4){
				//http响应成功
				if(xhr.status == 200 || xhr.status == 304){
					//接收服务器端响应的数据
					var data = xhr.responseText;
					alert(data);
				}
			}
		};
		
		
	};
	/**
	 * 获取XMLHttpRequest对象的固定写法
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
