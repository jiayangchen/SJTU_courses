package com.LoginTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginTestServlet
 */
@WebServlet("/LoginTestServlet")
public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//out.print(username);
		//out.print(password);
		
		if(username.equals("5140379036"))
		{
			if(username.equals("5140379036") && password.equals("root"))
			{
				
				session.setAttribute("sessionname", username);
				
				out.print("<script type = 'text/javascript'>");
				out.print("alert('管理员5140379036登陆成功，立即跳转');");
				out.print("window.location = 'isadmin.jsp';");
				out.print("</script>");
			}
			else
			{
				out.print("<script type = 'text/javascript'>");
				out.print("alert('管理员5140379036密码错误');");
				out.print("window.location = 'Login.jsp';");
				out.print("</script>");
			}
		}
		
		else
		{
			String url = "jdbc:mysql://localhost:3306/mydb"; 
			Connection con = null;
			PreparedStatement stat = null;
			ResultSet rs = null;
			response.setContentType("text/html;charset=gbk"); 
			
			boolean flag = false;
		    try
		    {
			   // Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		    	Class.forName("com.mysql.jdbc.Driver");			  	    
		    	con = DriverManager.getConnection(url, "root", "");
		    	
		    	String sqlAdmin = "select * from myusers";
		    	stat = con.prepareStatement(sqlAdmin);
		    	rs = stat.executeQuery();
		    	//out.print("aaaa");
		    	
		    	while (rs.next())
		    	{
		    		//out.print(rs.getString("studentID"));
		    		//out.print(rs.getString("password"));
		    		if((username.equals(rs.getString("studentID"))))
		    		{
		    			flag=true;
		    			if((username.equals(rs.getString("studentID")))&&(password.equals(rs.getString("password"))))
		    			{
			    			//out.print("isadmin");
		    				session.setAttribute("sessionname", username);
			    			out.print("<script type = 'text/javascript'>");
			    			out.print("alert('用户"+rs.getString("studentID")+"登陆成功，立即跳转');");
			    			out.print("window.location = 'isuser.jsp';");
			    			out.print("</script>");	
		    			}
		    			else
		    			{
		    				out.print("<script type = 'text/javascript'>");
			    			out.print("alert('用户"+rs.getString("studentID")+"密码错误');");
			    			out.print("window.location = 'Login.jsp';");
			    			out.print("</script>");	
		    			}
		    		}	 
		    	}
		    	if(flag==false)
		    	{
		    		out.print("<script type = 'text/javascript'>");
	    			out.print("alert('您尚未注册，前去注册');");
	    			out.print("window.location = 'regist.jsp';");
	    			out.print("</script>");	
		    	}
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
		}
		
	}
}
