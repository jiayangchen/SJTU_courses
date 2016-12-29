package com.cjy.dao;

import java.util.List;

import com.cjy.bean.Book;

public interface BookDAO {
	//DAO的增删改查接口
	public void addBook(Book book);
	public void deleteBook(Book book);
	public void updateBook(Book book);
	public List<Book> findBookByName(String bookname);
	public Book findBookById(int bookid);
	//列出所有图书
	public List<Book> listAllBooks();
	public List<Book> findBookByCategory(String category);

}
