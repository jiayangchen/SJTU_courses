<%@ page language="java" import="java.util.*,java.sql.*,java.util.Date,java.text.SimpleDateFormat" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付成功</title>
</head>
<body>
	<%
	if(session.getAttribute("sessionname")==null){
		out.print("<script type = 'text/javascript'>");
		out.print("alert('您尚未登录，请先登录');");
		out.print("window.location = 'Login.jsp';");
		out.print("</script>");	
	}
	else{
		out.print(session.getAttribute("sessionname")+"您已登陆，欢迎来到支付页面！");
		out.print("<br><a href=\"isuser.jsp\"><input type=\"submit\" value=\"个人中心\"/></a>");
		out.print("<form action=\"DeleteLogin\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"退出登录\"/>");
		out.print("</form>");
		
	}
	%>
	
	<h2>支付成功，订单信息如下</h2>
	<%
		session = request.getSession();
		Map<String,Integer> car = (Map<String,Integer>)session.getAttribute("shoppingCar");
		//insert order
		String studentid=(String)session.getAttribute("sessionname");
		
		String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;
		int rs = 0;
		response.setContentType("text/html;charset=gbk"); 			
		
		Class.forName("com.mysql.jdbc.Driver");			  	    
    	con = DriverManager.getConnection(url, "root", "");		    	
    	String sqlOrder = "INSERT INTO  myorder(studentID,BookID,Number,Date) VALUES (?,?,?,?)";	
    	stat = con.prepareStatement(sqlOrder);
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	out.print("<table border=1 align=\"center\"  class='Tab'>");
	   	out.print("<tr><td>StudentID</td><td>BookID</td><td>Number</td><td>Date</td></tr>");
    	if(car!=null && car.size()>0)
    	{
    		for(String bookid : car.keySet())
    		{	    	
    			String time = df.format(new Date());
    			int num=car.get(bookid);
		    	stat.setString(1,studentid);
		    	stat.setString(2,bookid);		    
		    	stat.setInt(3,num);	    
		    	stat.setString(4,time);	    
		    	rs = stat.executeUpdate();  
		    	out.print("<tr>");	   		
		   		out.print("<td>"+studentid+"</td>");
		   		out.print("<td>"+bookid+"</td>");
		   		out.print("<td>"+num+"</td>");	
		   		out.print("<td>"+df.format(new Date())+"</td>");	
		   		out.print("</tr>");
    		}
    	}
    	
    	
    	ResultSet ans = null;
    	String sqlupdate = "select * from mybook";
    	stat = con.prepareStatement(sqlupdate);
    	ans = stat.executeQuery();
    	int newQuantity = 0;   	
    	int i=0;
    	
    	while (ans.next())
    	{
    		for(String bookid : car.keySet())
    		{
	    		if((bookid.equals(ans.getString("BookID"))))
	    		{			    		
	    			newQuantity = ans.getInt("Quantity")-car.get(bookid);	
	    			String sql = "update mybook set Quantity='" + newQuantity + "' where BookID='" + bookid + "'";
	    			stat = con.prepareStatement(sql);
	    			i=stat.executeUpdate();
	    		}
    		}
    	}   
    	ans.close();
    	stat.close();
    	con.close();    	
	%>
	<p style="text-align:center;">总额：<%out.print(session.getAttribute("Total")+"元");%></p>
</body>
</html>