package com.cjy.action.admin;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class updatePBookAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private BookService bookService;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	@Override
	public String execute() throws Exception {
		this.bookService.findBookById(book.getBookid());
		return SUCCESS;
	}
	
}
