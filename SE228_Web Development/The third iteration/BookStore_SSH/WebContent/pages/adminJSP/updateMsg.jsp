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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新信息</title>
</head>
<body>
	<h2>更新信息</h2>
	<s:form action="isadmin.jsp" method="POST"><s:submit value="管理中心"/></s:form>
	<s:form action="logoutTest" method="POST"><s:submit value="退出"/></s:form>
	<table border="1" width="80%" align="center">
    	<tr>
    		<th>序号</th>
    		<th>用户名</th>
    		<th>密码</th>
    	</tr>
    		<tr>
    			<td>
    				<% out.print(session.getAttribute("id"));%>
    			</td>
    			<td>
    				<% out.print(session.getAttribute("username")); %>
    			</td>
    			<td>
    				<% out.print(session.getAttribute("password")); %>
    			</td>
    		</tr>
    </table>	
</body>
</html>