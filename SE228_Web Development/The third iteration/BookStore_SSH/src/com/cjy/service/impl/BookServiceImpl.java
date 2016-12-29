package com.cjy.service.impl;

import java.util.List;

import com.cjy.bean.Book;
import com.cjy.dao.BookDAO;
import com.cjy.service.BookService;

public class BookServiceImpl implements BookService {
	
	public BookServiceImpl(){}
	
	private BookDAO bookDAO;
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void addBook(Book book) {
		this.bookDAO.addBook(book);
	}
	
	public void deleteBook(Book book) {
		this.bookDAO.deleteBook(book);
	}
	
	public void updateBook(Book book) {
		this.bookDAO.updateBook(book);
	}
	
	public List<Book> findBookByName(String bookname) {
		return this.bookDAO.findBookByName(bookname);
	}
	
	public Book findBookById(int bookid) {
		return this.bookDAO.findBookById(bookid);
	}
	
	public List<Book> listAllBooks() {
		return this.bookDAO.listAllBooks();
	}

	public List<Book> findBookByCategory(String category) {
		return this.bookDAO.findBookByCategory(category);
	}
}
