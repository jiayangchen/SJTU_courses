package com.cjy.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.cjy.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	private OrderService orderService;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void getKeyExist() throws IOException{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			String id = (String) request.getParameter("id");
			out.print(id);
			List<Book> list = this.bookService.findBookByName(id);
			if(list.size()>0){
				out.print("<table border=\"1\">");
				out.print("<tr><td>序号</td><td>书名</td><td>作者</td><td>类别</td><td>价格</td><td>库存</td><td>销量</td><td>销售额</td></tr>");
				for(Book b : list){
					out.print("<tr>");
			   		out.print("<td>"+b.getBookid()+"</td>");
			   		out.print("<td>"+b.getBookname()+"</td>");
			   		out.print("<td>"+b.getAuthor()+"</td>");
			   		out.print("<td>"+b.getCategory()+"</td>");
			   		out.print("<td>"+b.getPrice()+"</td>");
			   		out.print("<td>"+b.getQuantity()+"</td>");	
			   		out.print("<td>"+orderService.findSales(b.getBookid())+"</td>");
			   		out.print("<td>"+b.getPrice()*orderService.findSales(b.getBookid())+"</td>");
			   		out.print("</tr>");
				}
				out.print("</table>");
			}
			else{
				out.print("没有这本书");
			}

	}
	
	
}
