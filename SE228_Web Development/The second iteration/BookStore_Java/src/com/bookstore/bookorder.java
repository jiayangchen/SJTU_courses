package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class bookorder
 */
@WebServlet("/bookorder")
public class bookorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookorder() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
		Map<String,Integer> car = (Map<String,Integer>)session.getAttribute("shoppingCar");
		
		if(car==null)
		{
			car = new HashMap<String,Integer>();
		}
		
		String[] books = request.getParameterValues("book");
		
		if(books!=null && books.length>0)
		{
			for(String bookid : books)
			{
				if(car.get(bookid) != null)
				{
					int num = car.get(bookid);
					car.put(bookid, num+1);
				}
				else
				{
					car.put(bookid,1);
				}
			}
		}
		session.setAttribute("shoppingCar", car);
		response.sendRedirect("ShoppingListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
