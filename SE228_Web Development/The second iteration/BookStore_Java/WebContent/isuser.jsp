<%@ page language="java"  import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
</head>
<body>
	<h1>这里是用户页面</h1>
	<form action="bookstore.jsp" method="POST"><p><input type="submit" value="首页"/></form>
	<form action="DeleteLogin" method="POST"><p><input type="submit" value="退出登录"/></form>
	<%=session.getAttribute("sessionname") %>,欢迎登录用户界面！
	<h2>您的购买记录如下</h2>
	
	<%
	
		String targetname = (String)session.getAttribute("sessionname");
	
	   	String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
	  
	   	Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection(url, "root", "");
	    	
		String sqlString = "select * from myorder";
		stat = con.prepareStatement(sqlString);
		rs = stat.executeQuery();
	   
	   	out.print("<table border=1 align=\"center\"  class='Tab'>");
	   	out.print("<tr><td>StudentID</td><td>BookID</td><td>Number</td><td>Date</td></tr>");
	   	while(rs.next()){
	   		if(targetname.equals(rs.getString("studentID")))
			{
		   		out.print("<tr>");	   		
		   		out.print("<td>"+rs.getString("studentID")+"</td>");
		   		out.print("<td>"+rs.getString("BookID")+"</td>");
		   		out.print("<td>"+rs.getString("Number")+"</td>");	
		   		out.print("<td>"+rs.getString("Date")+"</td>");	
		   		out.print("</tr>");
			}
	   	}	   	
	   	out.print("</table>");	  
	   	
	   	String totalcost = "select * from mybook natural join myorder";


   		
    %>
	
</body>
</html>