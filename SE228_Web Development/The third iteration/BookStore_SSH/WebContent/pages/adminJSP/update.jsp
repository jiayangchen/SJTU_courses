<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>更新用户</title>

</head>
<body>
	<h2>更新用户</h2>
	<s:form action="updateUser">
	<table>
		<tr>
			<td>
				<s:hidden name="user.id" value="%{user.id}"></s:hidden>
			</td>
		</tr>
	
		<tr>
			<td>
				<s:textfield name="user.username" value="%{user.username}" label="username"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:textfield name="user.password" value="%{user.password}" label="password"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:submit value="更新"/>
			</td>
		</tr>
	</table>	
	</s:form>
</body>
</html>