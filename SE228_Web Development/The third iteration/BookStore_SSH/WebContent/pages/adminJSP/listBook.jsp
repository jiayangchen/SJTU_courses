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
<title>书籍列表</title>
<script type="text/javascript">
		function del(){
			if(confirm("Are you sure?")){
				return true;
			}
			return false;
		}
	</script>
</head>
<body>
	<h2>用户列表</h2>
	<s:a href="isadmin.jsp">返回</s:a>
	 <table border="1" width="80%" align="center">
    	<tr>
    		<th>序号</th>
    		<th>书名</th>
    		<th>作者</th>
    		<th>类别</th>
    		<th>价格</th>
    		<th>库存</th>
    		<th>删除</th>
    		<th>更新</th>
    	</tr>
		<s:iterator value="#request.booklist" id="us">
    		<tr>
    			<td>
    				<s:property value="#us.bookid"/>
    			</td>
    			<td>
    				<s:property value="#us.bookname"/>
    			</td>
    			<td>
    				<s:property value="#us.author"/>
    			</td>
    			<td>
    				<s:property value="#us.category"/>
    			</td>
    			<td>
    				<s:property value="#us.price"/>
    			</td>
    			<td>
    				<s:property value="#us.quantity"/>
    			</td>
    			<td>
    				<s:a href="deleteBook.action?book.bookid=%{#us.bookid}" onclick="return del()">删除</s:a>
    			</td>
    			<td>
    				<s:a href="updatePBook.action?book.bookid=%{#us.bookid}">更新</s:a>
    			</td> 			
    		</tr>
    	</s:iterator>
    </table>	
</body>
</html>