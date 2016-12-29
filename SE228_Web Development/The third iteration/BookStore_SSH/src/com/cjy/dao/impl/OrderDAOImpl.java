package com.cjy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjy.bean.Order;
import com.cjy.dao.OrderDAO;

public class OrderDAOImpl implements OrderDAO{
	
	public OrderDAOImpl(){}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addOrder(Order order) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();		
	}
	@Override
	public List<Order> findOrderByUserId(int userid) {
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		//从数据库的Order表里拿到全部的数据，每一项是一个Order实例
		@SuppressWarnings("unchecked")
		List<Order> list = session.createQuery("from Order where UserID= ?").setInteger(0, userid).list();
		tx.commit();
		session.close();
		//返回Book集
		return list;
	}
	
	@Override
	public int findSales(int bookid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = Integer.parseInt(session.createSQLQuery("SELECT count(*) from myorder WHERE BookID = ?").setInteger(0, bookid).list().get(0).toString());
		//int result = Integer.parseInt(session.createSQLQuery("call fn_order(?)").setInteger(0, bookid).list().get(0).toString());
		//int result = Integer.parseInt(session.createSQLQuery("call fn_order(?)").setInteger(0, bookid).list().get(0).toString());
		tx.commit();
		session.close();
		return result;
	}
	
	@Override
	public int findUsers(int userid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = Integer.parseInt(session.createSQLQuery("SELECT count(*) from myorder WHERE UserID = ?").setInteger(0, userid).list().get(0).toString());
		//int result = Integer.parseInt(session.createSQLQuery("call fn_order(?)").setInteger(0, bookid).list().get(0).toString());
		tx.commit();
		session.close();
		return result;
	}
	
	@Override
	public List<Order> listOrder(String begin, String end) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Order> list = session.createQuery("from Order where date > ? and date < ?").setString(0, begin).setString(1, end).list();
		tx.commit();
		session.close();
		return list;
	}
	
	
}
