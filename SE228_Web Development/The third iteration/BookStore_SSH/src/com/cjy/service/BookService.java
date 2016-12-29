package com.cjy.service;

import java.util.List;

import com.cjy.bean.Book;

public interface BookService {

	//Service��ӿ�	
	public void deleteBook(Book book);
	public void updateBook(Book book);
	public List<Book> findBookByName(String bookname);
	public Book findBookById(int bookid);
	public void addBook(Book book);
	//�г�����ͼ��
	public List<Book> listAllBooks();
	public List<Book> findBookByCategory(String category);

}
