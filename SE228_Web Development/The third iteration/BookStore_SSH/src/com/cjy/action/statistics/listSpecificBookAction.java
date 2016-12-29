package com.cjy.action.statistics;

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

public class listSpecificBookAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	private BookService bookService;
	private OrderService orderService;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	
	public void slistspecificbook() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		category = (String) request.getParameter("q");
		out.print(category);
		List<Book> sbooklist = bookService.findBookByCategory(category);
		
		if(sbooklist.size()>0){
			out.print("<table border=\"1\">");
			out.print("<tr><td>序号</td><td>书名</td><td>作者</td><td>类别</td><td>价格</td><td>库存</td><td>销量</td><td>销售额</td></tr>");
			for(Book sb : sbooklist){
				out.print("<tr>");
		   		out.print("<td>"+sb.getBookid()+"</td>");
		   		out.print("<td>"+sb.getBookname()+"</td>");
		   		out.print("<td>"+sb.getAuthor()+"</td>");		   		
		   		out.print("<td>"+sb.getCategory()+"</td>");	  
		   		out.print("<td>"+sb.getPrice()+"</td>");	  
		   		out.print("<td>"+sb.getQuantity()+"</td>");	    
		   		out.print("<td>"+orderService.findSales(sb.getBookid())+"</td>");	  
		   		out.print("<td>"+sb.getPrice()*(orderService.findSales(sb.getBookid()))+"</td>");	  
		   		out.print("</tr>");
			}
			out.print("</table>");
		}
		else{
			out.print("出错");
		}
		
	}
}
