<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<style type="text/css">
		        div#container{width:1366px}
		        div#header {background-color:#99bbbb;}
		        h1 {margin-bottom:0; }
		        .Tab td{color: #99bbbb}
		    </style>
		<title>注册</title>
	</head>

	<body>
		
		<div id="container">
		    <div id="header">
		        <h1>注册      WelCome To BookStore</h1>
		    </div>
		</div>
		
		<p><a href="bookstore.jsp">首页</a>  | <a href="Login.jsp">登录</a></p>
		
		<div style="text-align:center;">
			<h1 >用户注册</h1>
			<form action="RegisterTestServlet" method="POST">
			<p>用户名:<input name="username" type="text"></p>
			<p>密 码:<input name="password" type="password"></p>
			<p>确认:<input name="ensure_password" type="password"></p>

			<p><input type="submit" value="提交"/> &nbsp;&nbsp;<input type="reset" value="重置"/></p>
			</form>
		</div>
	</body>
</html>