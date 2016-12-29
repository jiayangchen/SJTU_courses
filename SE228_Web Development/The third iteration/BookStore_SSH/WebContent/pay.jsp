<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付</title>
</head>
<body>
 <h1>付款成功</h1>
<s:form action="index.jsp" method="POST"><s:submit value="首页"/></s:form>
<s:form action="isuser.jsp" method="POST"><s:submit value="个人中心"/></s:form>
<s:form action="logoutTest" method="POST"><s:submit value="退出"/></s:form>
</body>
</html>