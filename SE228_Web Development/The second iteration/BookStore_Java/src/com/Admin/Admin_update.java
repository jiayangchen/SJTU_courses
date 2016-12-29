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
 * Servlet implementation class Admin_update
 */
@WebServlet("/Admin_update")
public class Admin_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_update() {
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
		
		String bid = request.getParameter("BookID");
		String bname = request.getParameter("BookName");
		String bauthor = request.getParameter("Author");
		String bpress = request.getParameter("Press");
		String bquantity = request.getParameter("Quantity");
		String bprice = request.getParameter("Price");
		
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;
		int rs = 0;	
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");			  	    
	    	con = DriverManager.getConnection(url, "root", "");	
    		    
			String sqlupdate = "update mybook set BookName=?,Author=?,Press=?,Quantity=?,Price=? where BookID=?";
			stat = con.prepareStatement(sqlupdate);
			
			stat.setString(1,bname );
			stat.setString(2,bauthor );
			stat.setString(3,bpress );
			stat.setInt(4,Integer.parseInt(bquantity) );
			stat.setInt(5,Integer.parseInt(bprice) );
			stat.setInt(6,Integer.parseInt(bid) );
			
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
		out.print("alert('图书更新成功！更新的图书信息是"+bid+" "+bname+" "+ bauthor +" "+ bpress +" "+bquantity+" "+ bprice +"');");
		out.print("window.location = 'isadmin.jsp';");
		out.print("</script>");
	}

}
