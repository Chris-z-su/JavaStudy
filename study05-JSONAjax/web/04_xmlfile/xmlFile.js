/**
 * 
 */
window.onload = function() {

	var xhr = ajaxFunction();

	/*try // Internet Explorer
	{
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.async = "false";
		xmlDoc.loadXML(text);
	} catch (e) {
		try // Firefox, Mozilla, Opera, etc.
		{
			parser = new DOMParser();
			xmlDoc = parser.parseFromString(text, "text/xml");
		} catch (e) {
			alert(e.message);
			return;
		}
	}*/

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var docXml = xhr.responseXML;
				// ����alert()���������в����������ݣ�
				// alert(data);

				// console��Firebug�Ŀ���̨
				// console.info(data);

				// ����XML����
				var provinceXMLElements = docXml.getElementsByTagName("province");
				//alert(provinceXMLElements.length);
				
				for (var i = 0; i < provinceXMLElements.length; i++) {
					//����XML���ݵ�province���飬��ȡ����province����
					var provinceXMLElement = provinceXMLElements[i];
					//��ȡprovince��ǩ�е�name����ֵ
					var provinceXMLValue = provinceXMLElement.getAttribute("name");
					//alert(provinceXMLValue);
					
					//<option value="">��ѡ��....</option>
					//����option��ǩ
					var option = document.createElement("option");
					//����option��value����ֵ
					option.setAttribute("value", provinceXMLValue);
					//�����ı��ڵ�
					var text = document.createTextNode(provinceXMLValue);
					option.appendChild(text);
					
					//<select id="province" name="province">
					//��ȡselect��ǩ
					var provinceElement = document.getElementById("province");
					//�����洴����option��ǩ��ӽ�ȥ
					provinceElement.appendChild(option);
				}
				
				//<select id="province" name="province">
				//���select��ǩ���¼���option��ǩ�����߱��κ��¼�����
				document.getElementById("province").onchange = function() {
					//��ճ��������б�
					var cityElement = document.getElementById("city");
					var options = cityElement.getElementsByTagName("option");
					/*for (var z = 1; z < options.length; z++) {
						cityElement.removeChild(options[z--]);
					}*/
					for (var z = options.length-1; z > 0; z--) {
						cityElement.removeChild(options[z]);
					}
					
					
					//1.�û���ҳ����ѡ���Ǹ�ʡ��
					var provinceValue = this.value;
					//alert(provinceValue);
					//2.����XML����
					//3.��ȡXML�����е�����province��Ϣ
					//4.����province��Ϣ
					for (var i = 0; i < provinceXMLElements.length; i++) {
						var provinceXMLElement = provinceXMLElements[i];
						//5.��ȡÿһ��ʡ����Ϣ
						var provinceXMLValue = provinceXMLElement.getAttribute("name");
						//6.ҳ����ѡ�е���Ϣ
						if(provinceXMLValue == provinceValue){
							//7.����Ӧʡ���µ����г��ж�ȡ����
							var cityXmlElements = provinceXMLElement.getElementsByTagName("city");
							//alert(cityXmlElements.length);
							for (var j = 0; j < cityXmlElements.length; j++) {
								var cityXmlElement = cityXmlElements[j];
								//��ȡ�ֽڵ�
								var cityXmlValue = cityXmlElement.firstChild.nodeValue;
								//alert(cityXmlValue);
								
								//<option value="">��ѡ��....</option>
								//����option��ǩ
								var option = document.createElement("option");
								//����option��value����ֵ
								option.setAttribute("value", cityXmlValue);
								
								var text = document.createTextNode(cityXmlValue);
								option.appendChild(text);
								
								cityElement.appendChild(option);
								
							}
							
						}
					}
				};
				
				
				
			}
		}
	};

	xhr.open("get", "../xmlFileServlet?timeStamp=" + new Date().getTime(), true);
	// ���������ײ���Ϣ
	// xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send(null);

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