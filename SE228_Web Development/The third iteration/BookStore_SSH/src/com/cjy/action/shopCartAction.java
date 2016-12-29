package com.cjy.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class shopCartAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String num;
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}


	public void shopCart() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String) request.getParameter("bid");
		String num = (String) request.getParameter("num");
		
		//ת����Int���ͣ��������
		int bookid = Integer.parseInt(id);
		int n = Integer.parseInt(num);
		
		//���ﳵʵ��
		Map<String, Object> session = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.get("shoppingcart");
		
		if(cart==null)
		{
			cart = new HashMap<Integer,Integer>();
			cart.put(bookid, n);
		}
		
		else
		{
			if(cart.containsKey(bookid))
			{
				int temp = cart.get(bookid);
				cart.put(bookid,temp+n);
			}
			else
			{
				cart.put(bookid, n);
			}
		}
		
		session.put("shoppingcart", cart);
		
		if(cart.size()>0)
		{
			out.print("<table border=1>");
			out.print("<tr><td>���</td><td>����</td><td>�۸�</td><td>����</td><td>�ܼ�</td></tr>");		
			for(int i : cart.keySet())
			{
				Book b = this.bookService.findBookById(i);
				out.print("<tr>");
		   		out.print("<td>"+b.getBookid()+"</td>");
		   		out.print("<td>"+b.getBookname()+"</td>");
		   		out.print("<td>"+b.getPrice()+"</td>");
		   		out.print("<td>"+cart.get(i)+"</td>");
		   		out.print("<td>"+(b.getPrice()*cart.get(i))+"</td>");
		   		out.print("</tr>");
			}
		 	out.print("</table>");	
		}
	}
}
