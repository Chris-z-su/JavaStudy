/**
 * 
 */
window.onload = function() {
	document.getElementById("checkusername").onclick = function() {
		//��ȡ�û���
		var username = document.getElementById("username").value;

		//��ȡXHTHttpRequest����
		var xhr = ajaxFunction();
		
		//ע�����
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				if(xhr.status == 200 || xhr.status == 304){
					var data = xhr.responseText;
					//��ȡ��Ҫ������div��ǩ
					document.getElementById("divcheck").innerHTML = data;
					
				}
			}
		};
		
		xhr.open("post", "../registerServlet?timeStamp="+new Date().getTime(), true);
		//���������ײ���Ϣ
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