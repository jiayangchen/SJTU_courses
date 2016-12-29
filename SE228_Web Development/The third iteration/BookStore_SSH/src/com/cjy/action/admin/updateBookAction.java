package com.cjy.action.admin;

import java.util.Map;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateBookAction extends ActionSupport{
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
		
		book.setBookid(book.getBookid());
		book.setBookname(book.getBookname());
		book.setAuthor(book.getAuthor());
		book.setCategory(book.getCategory());
		book.setPrice(book.getPrice());
		book.setQuantity(book.getQuantity());
				
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("bookid",book.getBookid());
		session.put("bookname",book.getBookname());
		session.put("author",book.getAuthor());
		session.put("author",book.getCategory());		
		session.put("price", book.getPrice());
		session.put("quantity",book.getQuantity());

		this.bookService.updateBook(this.book);
		
		return SUCCESS;		
	}
	
}
