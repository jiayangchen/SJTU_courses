<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<center>
<h1>网上书店</h1>
	<table border="1">
		<tr>
			<td>
			<h2>用户登录</h2>
			<s:form action="loginTest" method="POST">
				<s:textfield label="用户名" name="username"/>
				<s:password  label="密码" name="password"/>
				<s:submit value="登录" />				
			</s:form>
			</td>
			
			<td>
			<h2>用户注册</h2>
			<s:form action="registerTest" method="POST">
				<s:textfield label="用户名" name="username"/>
				<s:password  label="密码" name="password"/>
				<s:password  label="确认" name="epassword"/>	
				<s:submit value="注册"/>				
			</s:form>					
			</td>
		</tr>
	</table>
</center>
</body>
</html>