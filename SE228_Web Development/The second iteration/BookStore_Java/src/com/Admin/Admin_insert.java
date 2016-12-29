package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_insert
 */
@WebServlet("/Admin_insert")
public class Admin_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_insert() {
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
		response.setContentType("text/html;charset=gbk"); 			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");			  	    
	    	con = DriverManager.getConnection(url, "root", "");	
	    	
	    	String sqlUser = "INSERT INTO  mybook(BookID, BookName,Author,Press,Quantity,Price) VALUES (?,?,?,?,?,?)";	
	    	
	    	stat = con.prepareStatement(sqlUser);
	    	stat.setString(1,bid);
	    	stat.setString(2,bname);
	    	stat.setString(3,bauthor);
	    	stat.setString(4,bpress);
	    	stat.setString(5,bquantity);
	    	stat.setString(6,bprice);	   
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
		out.print("alert('图书插入成功！插入的图书信息是"+bid+" "+bname+" "+ bauthor +" "+ bpress +" "+bquantity+" "+ bprice +"');");
		out.print("window.location = 'isadmin.jsp';");
		out.print("</script>");
	}

}
