package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_search
 */
@WebServlet("/Admin_search")
public class Admin_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	
		String bname = request.getParameter("BookName");
		
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;	
		ResultSet rs = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");			  	    
	    	con = DriverManager.getConnection(url, "root", "");	

	    	String sqlupdate = "select * from mybook where BookName like '%"+bname+"%'";
	    	stat = con.prepareStatement(sqlupdate);
	    	rs = stat.executeQuery();
	
	    	out.print("<h2>查询的结果为：</h2>");
	    	out.print("<table border=1 align=\"center\"  class='Tab'>");
		   	out.print("<tr><td>BookID</td><td>BookName</td><td>Author</td><td>Press</td><td>Quantity</td><td>Price</td></tr>");
	    	while (rs.next())
	    	{
	    		out.print("<tr>");
		   		out.print("<td>"+rs.getString("BookID")+"</td>");		   		
		   		out.print("<td>"+rs.getString("BookName")+"</td>");
		   		out.print("<td>"+rs.getString("Author")+"</td>");
		   		out.print("<td>"+rs.getString("Press")+"</td>");
		   		out.print("<td>"+rs.getString("Quantity")+"</td>");
		   		out.print("<td>"+rs.getString("Price")+"</td>");
		   		out.print("</tr>");				    	
	    	}   	    
	    	stat.close();
	    	con.close();
		}
		catch (SQLException ex)
	    {
	    	while (ex != null)
	    	{
	    		ex.printStackTrace(out);
	    		ex = ex.getNextException();
	    	}
	    } 
	    catch (ClassNotFoundException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("<a href=\"isadmin.jsp\"><input type=\"submit\" value=\"返回\"></a>");
	}

}
