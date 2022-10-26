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
				// 利用alert()方法，进行测试数据内容，
				// alert(data);

				// console是Firebug的控制台
				// console.info(data);

				// 解析XML内容
				var provinceXMLElements = docXml.getElementsByTagName("province");
				//alert(provinceXMLElements.length);
				
				for (var i = 0; i < provinceXMLElements.length; i++) {
					//解析XML内容的province数组，获取单个province对象
					var provinceXMLElement = provinceXMLElements[i];
					//获取province标签中的name属性值
					var provinceXMLValue = provinceXMLElement.getAttribute("name");
					//alert(provinceXMLValue);
					
					//<option value="">请选择....</option>
					//创建option标签
					var option = document.createElement("option");
					//设置option的value属性值
					option.setAttribute("value", provinceXMLValue);
					//创建文本节点
					var text = document.createTextNode(provinceXMLValue);
					option.appendChild(text);
					
					//<select id="province" name="province">
					//获取select标签
					var provinceElement = document.getElementById("province");
					//将上面创建的option标签添加进去
					provinceElement.appendChild(option);
				}
				
				//<select id="province" name="province">
				//添加select标签的事件，option标签本身不具备任何事件内容
				document.getElementById("province").onchange = function() {
					//清空城市下拉列表
					var cityElement = document.getElementById("city");
					var options = cityElement.getElementsByTagName("option");
					/*for (var z = 1; z < options.length; z++) {
						cityElement.removeChild(options[z--]);
					}*/
					for (var z = options.length-1; z > 0; z--) {
						cityElement.removeChild(options[z]);
					}
					
					
					//1.用户在页面中选中那个省份
					var provinceValue = this.value;
					//alert(provinceValue);
					//2.解析XML内容
					//3.获取XML内容中的所有province信息
					//4.遍历province信息
					for (var i = 0; i < provinceXMLElements.length; i++) {
						var provinceXMLElement = provinceXMLElements[i];
						//5.获取每一个省份信息
						var provinceXMLValue = provinceXMLElement.getAttribute("name");
						//6.页面中选中的信息
						if(provinceXMLValue == provinceValue){
							//7.将对应省份下的所有城市读取出来
							var cityXmlElements = provinceXMLElement.getElementsByTagName("city");
							//alert(cityXmlElements.length);
							for (var j = 0; j < cityXmlElements.length; j++) {
								var cityXmlElement = cityXmlElements[j];
								//获取字节点
								var cityXmlValue = cityXmlElement.firstChild.nodeValue;
								//alert(cityXmlValue);
								
								//<option value="">请选择....</option>
								//创建option标签
								var option = document.createElement("option");
								//设置option的value属性值
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
	// 设置请求首部信息
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