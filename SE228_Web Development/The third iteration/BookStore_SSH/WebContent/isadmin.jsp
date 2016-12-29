<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ page import="com.cjy.action.loginAction,java.util.Map,java.util.Map,com.opensymphony.xwork2.ActionContext" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心</title>
</head>
<body>
<script src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
function ajaxlistUser() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	xmlHttpRequest.open("POST", "slistUser", true);  
        xmlHttpRequest.onreadystatechange = ajaxlistUserCall;                
        xmlHttpRequest.send();
    }
}   
function ajaxlistUserCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("userlist").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
}


function ajaxSales() {  
    if(window.ActiveXObject) {                
        xmlHttpRequest = new ActionXObject("Microsoft.XMLHTTP");  
    }  
    else if(window.XMLHttpRequest) {          
        xmlHttpRequest = new XMLHttpRequest();  
    }  
    if(xmlHttpRequest != null) { 
    	var bt = document.getElementById("bt").value;	
    	var et = document.getElementById("et").value;	
    	xmlHttpRequest.open("GET", "listdate?bt="+bt+"&et="+et, true);   
        xmlHttpRequest.onreadystatechange = ajaxSalesCall;                
        xmlHttpRequest.send();
    }
}   

function ajaxSalesCall() {  
    if(xmlHttpRequest.readyState == 4 ) {         
        if(xmlHttpRequest.status == 200) {        
            var text = xmlHttpRequest.responseText;        
            document.getElementById("sales").innerHTML = "<p>"+ text + "</p>"; 
        }  
    }  
} 
</script>

<script type="text/javascript">
function showCustomer(str)
{
var xmlhttp;    
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("POST","listspecificbook?q="+str,true);
xmlhttp.send();
}
</script>

	<h1>登陆成功！</h1>
	<%	
		out.print("欢迎5140379036来到管理员界面");
	%>
	<br>
	<s:form action="index.jsp" method="POST"><s:submit value="首页"/></s:form>
	<s:form action="logoutTest" method="POST"><s:submit value="退出"/></s:form>
	<br>
	
	<table border = "1">
	<tr>
		<td>
			<h2>增加用户</h2>
			<s:form action="saveUser" method="POST">
				<s:textfield name="username" label="用户名"></s:textfield>
				<s:textfield name="password" label="密码"></s:textfield>
				<s:submit value="添加" />
			</s:form>	
			
			<!-- 通过列出查找的用户来完成删除、更新操作 -->
			
			<h2>查找用户</h2>
			<s:form action="searchUser" method="POST">
				<s:textfield name="username" label="用户名"></s:textfield>
				<s:submit value="查找" />
			</s:form>
		</td>
	
		<td>
			<h2>增加图书</h2>
			<s:form action="saveBook" method="POST">
				<s:textfield name="bookname" label="书名"></s:textfield>
				<s:textfield name="author" label="作者"></s:textfield>
				<s:textfield name="category" label="类别"></s:textfield>
				<s:textfield name="price" label="价格"></s:textfield>
				<s:textfield name="quantity" label="库存"></s:textfield>
				<s:submit value="添加" />
			</s:form>	
			
			<!-- 通过列出查找的用户来完成删除、更新操作 -->
			
			<h2>查找图书</h2>
			<s:form action="searchBook" method="POST">
				<s:textfield name="bookname" label="书名"></s:textfield>
				<s:submit value="查找" />
			</s:form>
		</td>
	</tr>
	</table>
	<h2>数据统计</h2>
	<table border="1">
	<tr>
	<td>
	<h2>用户列表</h2>
	<button type="button" onclick="ajaxlistUser()" >列出用户</button>
	<div id="userlist"></div>
	</td>
	<td>
	<h2>书籍分类</h2>
	<form action="" style="margin-top:15px;"> 	
	<label>请选择一种分类：
	<select name="customers"  onchange="showCustomer(this.value)" style="font-family:Verdana, Arial, Helvetica, sans-serif;">
	<option value="IT">IT</option>
	<option value="Fiction">Fiction</option>
	<option value="Science">Science</option>
	<option value="Literature">Literature</option>
	</select>
	</label>
	</form>
	<div id="txtHint"></div>
	</td>
	<td>
	<h2>销售统计</h2>
	  起始日期：<input type="date" name="bt" id="bt" />  <br/> 
	  结束日期：<input type="date" name="et" id="et" />   
	 <button type="button" onclick="ajaxSales()" >查看</button> 
	  <div id="sales">Sales</div>
	</td>
	</tr>
	</table>
</body>
</html>