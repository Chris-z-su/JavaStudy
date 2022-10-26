/**
 * ��ҳ�����ݼ������֮����ִ�����´���
 */
window.onload = function() {
	document.getElementById("ok").onclick = function(){
		// ʵ��Ajax�첽����,��ҳ��ı�û�й�ϵ(�������й�ϵ)
		//alert("111");
		/*
		 * 1.����XMLHttpRequest�������Ժͷ���
		 */
		var xhr = ajaxFunction();
		
		/*
		 * 2. �ͻ������������������
		 * ����XMLHttpRequest�����open(method, url, asynch, username, password)����
		 * 		* method:��������,GET��POST.
		 * 		* url:����·��,���������·�������·��.
		 * 		* asynch:��ʾ�Ƿ��첽,true(Ĭ��ֵ)��ʾ�첽,false��ʾͬ��
		 * 		* username, password:������ http��֤���û��������룬һ�㲻ָ��
		 */
		//timeStamp:��ʾʱ���������IE������ڶ���δ��Ӧ�����
		xhr.open("GET", "testServlet?timeStamp="+new Date().getTime()+"&c=9", true);

		/*
		 * 3.�ͻ�����������˷�������
		 * ����XMLHttpRequest�����send()����
		 * 		�������������GET��ʽ�Ļ�,send()����������������,�������˽��ղ���
		 * 		�ò��費�ܱ�ʡ��,�������ݿ��Ը�дΪ:xhr.send(null);
		 */
		xhr.send("a=7&b=8");

		/*
		 * 4.����������ͻ��˽�����Ӧ
		 * ����XMLHttpRequest�����onreadystatechange����:���ڼ����������˵�״̬
		 * 		readyState:��ʾAjax����ĵ�ǰ״̬������ֵ�����ִ���
					0 ����δ��ʼ���� ��û�е��� open ����
					1 �������ڼ��ء� open �����ѱ����ã��� send ������û�б�����
					2 �����Ѽ�����ϡ�send �ѱ����á������Ѿ���ʼ
					3 �������С����������ڷ�����Ӧ
					4 ������ɡ���Ӧ�������
				status:	����״̬�뼰�京�壺
					404 û�ҵ�ҳ��(not found)
					403 ��ֹ����(forbidden)
					500 �ڲ�����������(internal service error)
					200 һ������(ok)
					304 û�б��޸�(not modified)(����������304״̬����ʾԴ�ļ�û�б��޸� )
		 * 
		 */
		//onreadystatechange����xmlhttpRequest�����readystate״̬���͸ı��ʱ�򣬴����˺���
		xhr.onreadystatechange = function(){
			//���շ������˵�ͨ��״̬
			//alert(xhr.readyState);		//2,3,4һ������״̬,ֻ��ע4��״̬
			//alert(xhr.status);//״̬��
			//���ݽ������
			if(xhr.readyState == 4){
				//http��Ӧ�ɹ�
				if(xhr.status == 200 || xhr.status == 304){
					//���շ���������Ӧ������
					var data = xhr.responseText;
					alert(data);
				}
			}
		};
		
		
	};
	/**
	 * ��ȡXMLHttpRequest����Ĺ̶�д��
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
