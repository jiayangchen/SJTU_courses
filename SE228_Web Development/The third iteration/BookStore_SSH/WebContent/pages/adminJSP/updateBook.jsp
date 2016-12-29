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
<title>更新图书</title>

</head>
<body>
	<h2>更新图书</h2>
	<s:form action="updateBook">
	<table>
		<tr>
			<td>
				<s:hidden name="book.bookid" value="%{book.bookid}"></s:hidden>
			</td>
		</tr>
	
		<tr>
			<td>
				<s:textfield name="book.bookname" value="%{book.bookname}" label="书名"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:textfield name="book.author" value="%{book.author}" label="作者"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:textfield name="book.category" value="%{book.category}" label="类别"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:textfield name="book.price" value="%{book.price}" label="价格"></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:textfield name="book.quantity" value="%{book.quantity}" label="库存"></s:textfield>
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