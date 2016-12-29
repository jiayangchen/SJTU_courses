package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingListServlet
 */
@WebServlet("/ShoppingListServlet")
public class ShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
		String url = "jdbc:mysql://localhost:3306/mydb"; 
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
			
		HttpSession session = request.getSession();
		Map<String,Integer> car = (Map<String,Integer>)session.getAttribute("shoppingCar");
		
		if(car!=null && car.size()>0)
		{
			out.println("<div style=\"text-align:center\"><p>您购物车里的书籍有：</p></div>");
			out.print("<table border=1 align=\"center\"  class='Tab'>");
		   	out.print("<tr><td>BookID</td><td>Quantity</td></tr>");
			for(String bookid : car.keySet())
			{
				out.print("<tr>");
				//out.print("<td>"+rs.getString("BookName")+"</td>");
				out.print("<td>" + bookid +"</td>");
				out.print("<td>" + car.get(bookid) +"</td>");
				out.print("</tr>");
			}			
			out.print("</table>");
		}
		else
		{
			out.print("<script type = 'text/javascript'>");
			out.print("alert('您还未购买任何书籍！');");
			out.print("window.location = 'bookstore.jsp';");
			out.print("</script>");
		}
		
		double total=0;
	    try
	    {
		   // Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	    	Class.forName("com.mysql.jdbc.Driver");			  	    
	    	con = DriverManager.getConnection(url, "root", "");
	    	
	    	String sqlprice = "select * from mybook";
	    	stat = con.prepareStatement(sqlprice);
	    	rs = stat.executeQuery();
	    	
	    	
	    	while (rs.next())
	    	{
	    		for(String bookid : car.keySet())
	    		{
		    		if((bookid.equals(rs.getString("BookID"))))
		    		{			    		
		    			total+=(car.get(bookid))*(rs.getInt("Price"));			    			
		    		}
	    		}
	    	}
	    	
	    	out.print("<p style=\"text-align:center;\">总价："+total);
	    	rs.close();
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
	 											
		out.print("<div style=\"text-align:center;\">");
		out.print("<a href=\"bookstore.jsp\"><input type=\"submit\" value=\"前往书店\"></a>");
		out.print("<a href=\"success.jsp\"><input type=\"submit\" value=\"立即支付\"></a>");
		session.setAttribute("Total", total);
		out.print("<form action=\"DeleteSession\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"清空购物车\">");
		out.print("</form>");
		out.print("</div>");	
		
	}
}
