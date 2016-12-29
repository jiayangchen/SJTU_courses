<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
<script src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
function ajaxOrder() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "listAllOrderByUser", true);  
        xmlHttpRequest.onreadystatechange = ajaxOrderCall;                
        xmlHttpRequest.send();
    }
}   
function ajaxOrderCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("orderlist").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}


function mongos() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "mongosearch", true);  
        xmlHttpRequest.onreadystatechange = mongosCall;                
        xmlHttpRequest.send();
    }
}   
function mongosCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("mongosr").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}

function mongoi() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "mongoinsert", true);  
        xmlHttpRequest.onreadystatechange = mongoiCall;                
        xmlHttpRequest.send();
    }
}   
function mongoiCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("mongoir").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}

function mongou() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "mongoupdate", true);  
        xmlHttpRequest.onreadystatechange = mongouCall;                
        xmlHttpRequest.send();
    }
}   
function mongouCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("mongour").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}

function mongod() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "mongodelete", true);  
        xmlHttpRequest.onreadystatechange = mongodCall;                
        xmlHttpRequest.send();
    }
}   
function mongodCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("mongodr").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}



</script>
	<h1>个人中心</h1>
	<% out.print("欢迎"+session.getAttribute("login")+"来到书店"); %>
	<table border="1">
	<tr>
	<td>
	<s:form action="index.jsp" method="POST"><s:submit value="首页"/></s:form>
	<s:form action="logoutTest" method="POST"><s:submit value="退出"/></s:form>	
	<button type="button" onclick="ajaxOrder()" >历史订单</button>
	<div id="orderlist"></div>
	</td>
	<td>
	<h3>个人设置</h3>
	<p>头像</p>
	<img src="resources/1.jpg" width="128" height="128">
	<br/>
	<br/>
	<button type="button" onclick="mongos()" >查询</button>
	<div id="mongosr">查询结果</div>	
	<br/>
	<!-- Key：<input type="text" name="key" id="key" />   <br/>
	Value：<input type="text" name="value" id="value" />    -->
	<button type="button" onclick="mongoi()" >插入头像</button>
	<div id="mongoir">插入结果</div>
	<br/>
	<button type="button" onclick="mongod()" >删除</button>
	<div id="mongodr">删除结果</div>
	<br/>
<!-- 	图片URL：<input type="text" name="photoURL" id="photoURL" />   
	  手机号：<input type="text" name="phone" id="phone" />   --> 
	 <button type="button" onclick="mongou()" >修改</button>
	 <div id="mongour">修改结果</div>
	</tr>
	</table>
</body>
</html>