package com.cjy.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class listBookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public void listAllBook() throws Exception {		
		List<Book> book = this.bookService.listAllBooks();	
		@SuppressWarnings("unused")
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if(book.size()>0){
			out.print("<table border=\"1\">");
			out.print("<tr><td>序号</td><td>书名</td><td>作者</td><td>类别</td><td>价格</td><td>库存</td></tr>");
			for(Book b : book){
				out.print("<tr>");
		   		out.print("<td>"+b.getBookid()+"</td>");
		   		out.print("<td>"+b.getBookname()+"</td>");
		   		out.print("<td>"+b.getAuthor()+"</td>");
		   		out.print("<td>"+b.getCategory()+"</td>");
		   		out.print("<td>"+b.getPrice()+"</td>");
		   		out.print("<td>"+b.getQuantity()+"</td>");
		   		
		   		out.print("</tr>");
			}
			out.print("</table>");			
		}
		else{
			out.print("出错");
		}
	}
	
}
