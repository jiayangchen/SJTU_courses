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
 * Servlet implementation class Admin_delete
 */
@WebServlet("/Admin_delete")
public class Admin_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_delete() {
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
		PrintWriter out = response.getWriter();
		String bid = request.getParameter("BookID");
		//out.print(bid);
	
		String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;	
		int rs = 0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");			  	    
	    	con = DriverManager.getConnection(url, "root", "");	

	    	String sqldelete = "delete from mybook where BookID=?";
	    	stat = con.prepareStatement(sqldelete);
	    	stat.setInt(1, Integer.parseInt(bid));
	    	rs = stat.executeUpdate();
	    	
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
		
		out.print("<script type = 'text/javascript'>");
		out.print("alert('É¾³ý³É¹¦');");
		out.print("window.location = 'isadmin.jsp';");
		out.print("</script>");
	}

}
