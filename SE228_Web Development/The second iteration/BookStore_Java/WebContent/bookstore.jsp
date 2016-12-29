<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"
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
	<title>网上书店</title>
</head>

<body>
	<div id="container">
	    <div id="header">
	 		<h1>WelCome To BookStore</h1>
	 	</div>
	</div>
	<%
	if(session.getAttribute("sessionname")==null){
		out.print("<p><a href=\"Login.jsp\">登录</a> | <a href=\"regist.jsp\">注册</a></p>");
	}
	else{
		out.print(session.getAttribute("sessionname")+"您已登陆，欢迎购买书籍！");
		out.print("<br><a href=\"isuser.jsp\"><input type=\"submit\" value=\"个人中心\"/></a>");
		out.print("<form action=\"DeleteLogin\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"退出登录\"/>");
		out.print("</form>");
		
	}
	%>
 	<form action="bookorder" method="post">
   	<%
	   String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
	  
	   	Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(url, "root", "");
		stat = con.createStatement();
		String sqlString = "select * from mybook";
		rs = stat.executeQuery(sqlString);
	   
	   	out.print("<table border=1 align=\"center\"  class='Tab'>");
	   	out.print("<tr><td></td><td>BookName</td><td>Author</td><td>Press</td><td>Quantity</td><td>Price</td></tr>");
	   	while(rs.next())
	   	{
	   		out.print("<tr>");
	   		//out.print("<td>"+rs.getString("BookID")+"</td>");
	   		out.print("<td><input type = 'checkbox' name ='book' value = "+rs.getString("BookID")+"></td>");
	   		out.print("<td>"+rs.getString("BookName")+"</td>");
	   		out.print("<td>"+rs.getString("Author")+"</td>");
	   		out.print("<td>"+rs.getString("Press")+"</td>");
	   		out.print("<td>"+rs.getString("Quantity")+"</td>");
	   		out.print("<td>"+rs.getString("Price")+"</td>");
	   		//out.print("<td><input type=\"number\" name=\"points\" min=\"1\" max=\"10\" /></td>");
	   		out.print("</tr>");
	   	}	   	
	   	out.print("</table>");	
	   	%>
	   	<br>
	   	 <div style="text-align:center;">
    	<input type='submit' value='添加到购物车'/>
    	<input type='submit' value='查看购物车'/>
    </div>
    </form>
	   	<% 
	   	stat1 = con.createStatement();
	   	out.print("<h2>本月销售排行榜</h2>");
	   	String sqlbest = "select * from mybook order by Quantity";
	   	rs1 = stat.executeQuery(sqlbest);
	   	
	   	out.print("<table border=1 align=\"center\"  class='Tab'>");
	   	out.print("<tr><td></td><td>BookName</td><td>Author</td><td>Price</td></tr>");
	   	while(rs1.next())
	   	{
	   		out.print("<tr>");
	   		//out.print("<td>"+rs.getString("BookID")+"</td>");
	   		out.print("<td><input type = 'checkbox' name ='book' value = "+rs1.getString("BookID")+"></td>");
	   		out.print("<td>"+rs1.getString("BookName")+"</td>");
	   		out.print("<td>"+rs1.getString("Author")+"</td>");
	   		
	   		out.print("<td>"+rs1.getString("Price")+"</td>");
	   		//out.print("<td><input type=\"number\" name=\"points\" min=\"1\" max=\"10\" /></td>");
	   		out.print("</tr>");
	   	}	   	
	   	out.print("</table>");	
    %>
 
   
</body>
</html>