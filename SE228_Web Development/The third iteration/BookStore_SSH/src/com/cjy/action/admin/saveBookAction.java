package com.cjy.action.admin;

import com.cjy.bean.Book;
import com.cjy.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class saveBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private String bookname;
	private String author;
	private String category;
	private double price;
	private int quantity;
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String execute() throws Exception {
		
		//≤Â»ÎÕº È
		Book book = new Book();
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setCategory(category);
		book.setPrice(price);
		book.setQuantity(quantity);
		bookService.addBook(book);
		
		return SUCCESS;
	}
	
	
}
