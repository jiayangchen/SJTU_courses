package com.cjy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjy.bean.Book;
import com.cjy.dao.BookDAO;

public class BookDAOImpl implements BookDAO {
	
	public BookDAOImpl(){}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();		
	}
	@Override
	public void deleteBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(book);
		tx.commit();
		session.close();		
	}
	@Override
	public void updateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(book);
		tx.commit();
		session.close();		
	}
	@Override
	public List<Book> findBookByName(String bookname) {
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		
		//从数据库的Book表里拿到全部的数据，每一项是一个Book实例
		@SuppressWarnings("unchecked")
		List<Book> list = session.createQuery("from Book where BookName= ?").setString(0, bookname).list();
		
		tx.commit();
		session.close();
		//返回Book集
		return list;
	}
	@Override
	public Book findBookById(int bookid) {
		Book book = null;			
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		book = (Book) session.get(Book.class, bookid);
		tx.commit();
		session.close();
		return book;
	}
	@Override
	public List<Book> listAllBooks() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Book> allbooklist = session.createQuery("from Book").list();
		tx.commit();
		session.close();
		return allbooklist;
	}
	@Override
	public List<Book> findBookByCategory(String category) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Book> spbook = session.createQuery("from Book where Category=?").setString(0, category).list();
		tx.commit();
		session.close();
		return spbook;
	}

}
