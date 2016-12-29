package com.RegisterTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormRequestServlet
 */
@WebServlet("/RegisterTestServlet")
public class RegisterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ensure_password = request.getParameter("ensure_password");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		/*
		out.print("<p>ע����û����ǣ�"+username+"</p>");
		out.print("<p>ע��������ǣ�"+password+"</p>");
		out.print("<p>ȷ�ϵ������ǣ�"+ensure_password+"</p>");
		*/
		
		if(password.equals(ensure_password)){
			
			String url = "jdbc:mysql://localhost:3306/mydb"; 
			Connection con = null;
			PreparedStatement stat = null;
			int rs = 0;
			response.setContentType("text/html;charset=gbk"); 			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");			  	    
		    	con = DriverManager.getConnection(url, "root", "");	
		    	
		    	String sqlUser = "INSERT INTO  myusers(studentID, password) VALUES (?,?)";	
		    	
		    	stat = con.prepareStatement(sqlUser);
		    	stat.setString(1,username);
		    	stat.setString(2,password);
		    	
		    	session.setAttribute("sessionname", username);
		    	
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
			out.print("alert('ע��ɹ�������ǰ���������û�����"+username+"����������"+password+"');");
			out.print("window.location = 'bookstore.jsp';");
			out.print("</script>");
		}
		else{
			out.print("<script type = 'text/javascript'>");
			out.print("alert('���벻һ��,���������룡');");
			out.print("window.location = 'regist.jsp';");
			out.print("</script>");
		}
		
		//String[] channel = request.getParameterValues("channel");
		//Enumeration<String>elem = request.getParameterNames();
		/*
		PrintWriter out = response.getWriter();
		out.print("<p>ע����û����ǣ�"+username+"</p>");
		out.print("<p>ע��������ǣ�"+password+"</p>");
		out.print("<p>ע��������ǣ�"+ensure_password+"</p>");
		*/
		/*out.print("<p>ע�����Ϣ��Դ�ǣ�");
		for (String c:channel){
			out.print(c+"&nbsp;");
		}
		out.print("</p><p>���пͻ�����Ĳ������ǣ�");
		while(elem.hasMoreElements()){
			out.print(elem.nextElement()+"&nbsp;");
		}*/
		/*
		out.print("</p>");
		out.flush();
		out.close();
		*/
		
	}

}
