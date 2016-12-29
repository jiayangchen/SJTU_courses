<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书店首页</title>
<script src="js/jquery-2.1.0.js"></script>
<script>
$(document).ready(function(){
	  $("#btn0").click(function(){
	    $('#test').load('resources/poem.txt');
	  })
	})
	$(document).ready(function(){
	  $("#btn1").click(function(){
	    $('#test').load('resources/poem1.txt');
	  })
	})
	$(document).ready(function(){
	  $("#btn2").click(function(){
	    $('#test').load('resources/poem2.txt');
	  })
	})
	$(document).ready(function(){
	  $("#btn3").click(function(){
	    $('#test').load('resources/poem3.txt');
	  })
	})
	$(document).ready(function(){
	  $("#btn4").click(function(){
	    $('#test').load('resources/poem4.txt');
	  })
	})
	
</script>
</head>
<body>

<script src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
var xmlHttpRequest = null;   

function ajaxRequest() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	var id = document.getElementById("id").value;
    	
    	xmlHttpRequest.open("POST", "getKeyExist?id="+id, true);  
        xmlHttpRequest.onreadystatechange = ajaxCall;                
        xmlHttpRequest.send();
    }
}   

function ajaxCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("myDiv").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}  


function ajaxBook() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "listAllBook", true);  
        xmlHttpRequest.onreadystatechange = ajaxBookCall;                
        xmlHttpRequest.send();
    }
}   
function ajaxBookCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("bookstore").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}

function ajaxCart() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	var bid = document.getElementById("bid").value;	
    	var num = document.getElementById("num").value;	

    	xmlHttpRequest.open("POST", "shopCart?bid="+bid+"&num="+num, true);   
        xmlHttpRequest.onreadystatechange = ajaxCartCall;                
        xmlHttpRequest.send();
    }
}   

function ajaxCartCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("shoppingcart").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
} 

</script>

	<h1>书店首页</h1>
	<% 	
	String name = (String)session.getAttribute("login");
	if(name==null)
	{
		out.print("<p><a href=\"login.jsp\">登录</a> | <a href=\"login.jsp\">注册</a></p>");
	}
	else if(name.equals("5140379036"))
	{
		out.print("管理员"+session.getAttribute("login")+"已登陆");
		out.print("<br><a href=\"isadmin.jsp\"><input type=\"submit\" value=\"管理中心\"/></a>");
		out.print("<form action=\"logoutTest\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"退出\"/>");
		out.print("</form>");	
	}
	else
	{
		out.print("用户"+session.getAttribute("login")+"已登陆，欢迎购买书籍");
		out.print("<br><a href=\"isuser.jsp\"><input type=\"submit\" value=\"个人中心\"/></a>");
		out.print("<form action=\"logoutTest\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"退出\"/>");
		out.print("</form>");			
	}
	%>
	<table>
	<tr>
	<td>
	<table border="1">
	<tr>
	<td>
	<h2>查找图书</h2>
	</td>
	</tr>
	<tr>
	<td>
           书名：<input type="text" name="id" id="id" />    
	<button type="button" onclick="ajaxRequest()" >查询</button> 
    </td>
    </tr>
    <tr>
    <td>
    <div id="myDiv">查询结果</div>
	</td>
	</tr>
	</table>
	</td>
	<td>
	<table border="1">
	<tr>
	<td>
	<h2>书店</h2>
	</td>	
	</tr>
	<tr>
	<td>
	<button type="button" onclick="ajaxBook()" >刷新</button>
	  书号：<input type="text" name="bid" id="bid" />   
	  数量：<input type="text" name="num" id="num" />   
	 <button type="button" onclick="ajaxCart()" >添加到购物车</button> 
	</td>
	</tr>
    <tr>
    <td>   
	    <table>
	    <tr>
		    <td>
		    	<div id="bookstore">书库</div>  
		    </td>
		    <td>
			    <table border="1">
			    <%
			    	for(int i=0;i<5;i++)
			    	{
			    		out.print("<tr>");
			    		out.print("<td>");
			    		out.print("<button id='btn"+i+"' type='button'>书籍详情</button>");
			    		out.print("</td>");
			    		out.print("</tr>");
			    	}
			    %>
		    	
		    	</table>
		    </td>
	    </tr>
	    </table>
	</td>
	</tr>
	<tr>
	<td>
	
	<h3 id="test">书籍详情内容</h3>
	</td>
	</tr>
</table>
</td>
<td>
<table border="1">
<tr>
<td>
<h2>购物车</h2>
</td>
</tr>
<tr>
<td>
<div id="shoppingcart"></div>

<s:form action="pay" method="POST"><s:submit value="确认付款"/></s:form>
 
</td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>