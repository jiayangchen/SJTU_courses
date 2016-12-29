package com.cjy.action.admin;

import java.util.List;
import java.util.Map;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class searchBookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	private String bookname;
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(bookname);
		@SuppressWarnings("unchecked")
		Map<String, List<Book>> request = (Map<String, List<Book>>) ActionContext.getContext().get("request");
		request.put("booklist", this.bookService.findBookByName(bookname));	
		
		return SUCCESS;
	}
	
}
