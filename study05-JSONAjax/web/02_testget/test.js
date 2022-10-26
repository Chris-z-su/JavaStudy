window.onload = function() {
	document.getElementById("ok").onclick = function(){
		//1.��ȡXHRHttpRequest����
		var xhr = ajaxFunction();
		
		/*
		 *  2.ע�����
		 *  readyState ���Ա�ʾAjax����ĵ�ǰ״̬������ֵ�����ִ���
				0 ����δ��ʼ���� ��û�е��� open ����
				1 �������ڼ��ء� open �����ѱ����ã��� send ������û�б�����
				2 �����Ѽ�����ϡ�send �ѱ����á������Ѿ���ʼ
				3 �������С����������ڷ�����Ӧ
				4 ������ɡ���Ӧ�������
				
				ע��:��������Զ�ò���.
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
		
		//3.�ͻ�����������˽�������
		xhr.open("post", "testServlet?timeStamp="+new Date().getTime(), true);
		
		//�������ʽ��POST����Ҫ���������ײ���Ϣ
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		
		//4.�ͻ�����������˷�������
		xhr.send("a=7&b=8");
		/*
		 * send()��������������û�й�ϵ?���ڹ�ϵ
		 * 	* �������������GET��ʽ�Ļ�,send()�������͵���������,�������˽��ղ���
		 * 		* �ò��費�ܱ�ʡ��,��дΪ:xhr.send(null);
		 * 	* �������������POST��ʽ��,send()�������͵���������,�������˿��Խ���
		 * 		* ����Ҫ���������ײ���Ϣ:"Content-Type"Ϊ"application/x-www-form-urlencoded"
		 */
	};
	
	/**
	 * ��ȡXMLHttpRequest����Ĺ̶�д��
	 * 
	 * Դ��·����
	 * 		F:\BaiduNetdiskDownload\day31Ajax&JSON
	 * 				\day31Ajax&JSON\����ʮһ��Ajax&JSON\Day30_AjAX����
	 * 				\����\02_Ajax\��ȡXMLHttpRequest����.txt
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