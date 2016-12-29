package com.cjy.action.statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cjy.bean.Book;
import com.cjy.bean.Order;
import com.cjy.service.BookService;
import com.cjy.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class listSalesAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bt;
	private String et;
	private OrderService orderService;
	private BookService bookService;
	
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getEt() {
		return et;
	}
	public void setEt(String et) {
		this.et = et;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public void listsales () throws IOException {
		@SuppressWarnings("unused")
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(bt+" "+et);
		List<Order> list = orderService.listOrder(bt, et);
		System.out.println(list.size());
		
		out.print("<table border=\"1\">");
		out.print("<tr><td>序号</td><td>书号</td><td>销量</td><td>销售额</td></tr>");

		for(Order o : list){
			int key = o.getBookid();
			Book b = bookService.findBookById(key);
			out.print("<tr>");
	   		out.print("<td>"+o.getOrderid()+"</td>");
	   		out.print("<td>"+o.getBookid()+"</td>");
	   		out.print("<td>"+o.getAmount()+"</td>");		   		
	   		out.print("<td>"+o.getAmount()*11+"</td>");	  	  
	   		out.print("</tr>");
		}
		out.print("</table>");

		/*List<Order> list = orderService.findOrderBetDate(begin, end);
		out.print("<table border=\"1\">");
		out.print("<tr><td>序号</td><td>书号</td><td>销量</td><td>销售额</td></tr>");
		
		System.out.println(list.size());
		for(Order o : list){
			//int key = o.getBookid();
			out.print("<tr>");
	   		out.print("<td>"+o.getOrderid()+"</td>");
	   		out.print("<td>"+o.getBookid()+"</td>");
	   		//out.print("<td>"+Collections.frequency(list,key)+"</td>");		   		
	   		out.print("<td>"+"销售额"+"</td>");	  	  
	   		out.print("</tr>");
		}
		out.print("</table>");*/
	}
}
