<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员中心</title>
</head>
<body>
	<h1>这里是管理员界面</h1>
	<p><a href="bookstore.jsp">首页</a>
	<%=session.getAttribute("sessionname") %>,欢迎登录管理员界面！
	
	<h3>查询图书</h3>
	<form action="Admin_search" method="post">
	    BookName:<input type="text" name="BookName" class="BookName" placeholder="请输入书名">	 
	    <input type="submit" value="查询">
	</form>
	
	<h3>添加图书</h3>
	<form action="Admin_insert" method="post">
	    BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入书号"><br>
	    BookName:<input type="text" name="BookName" class="BookName" placeholder="请输入书名"><br>
	    Author:<input type="text" name="Author" class="Author" placeholder="请输入作者"><br>
	    Press:<input type="text" name="Press" class="Press" placeholder="请输入出版社"><br>
	    Quantity:<input type="text" name="Quantity" class ="Quantity" placeholder="请输入书籍数量"><br>
	    Price:<input type="text" name="Price" class ="Price" placeholder="请输入书籍价格">
	    <input type="submit" value="确认添加">
	</form>
	
	<h3>更新图书</h3>
	<form action="Admin_update" method="post">
	    BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入书号"><br>
	    BookName:<input type="text" name="BookName" class="BookName" placeholder="请输入书名"><br>
	    Author:<input type="text" name="Author" class="Author" placeholder="请输入作者"><br>
	    Press:<input type="text" name="Press" class="Press" placeholder="请输入出版社"><br>
	    Quantity:<input type="text" name="Quantity" class ="Quantity" placeholder="请输入书籍数量"><br>
	    Price:<input type="text" name="Price" class ="Price" placeholder="请输入书籍价格">
	    <input type="submit" value="更新图书">
	</form>
	
	<h3>删除图书</h3>
	<form action="Admin_delete" method="post">
	    BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入书号">	    
	    <input type="submit" value="确认删除">
	</form>
	
</body>
</html>