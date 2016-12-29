package com.cjy.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjy.bean.User;
import com.cjy.dao.UserDAO;


//��DAO�ӿڵ�ʵ��
public class UserDAOImpl implements UserDAO {
	
	public UserDAOImpl(){}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//��д��ɾ�Ĳ�����ʵ��
	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<User> findUserByName(String name) {
		Session session = sessionFactory.openSession();
		//User findUser = (User) session.get(User.class, name);
		
		Transaction tx = session.beginTransaction();
		
		//�����ݿ��User�����õ�ȫ�������ݣ�ÿһ����һ��Userʵ��
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery("from User where username = ?").setString(0, name).list();
		//��ʼ��
		
		tx.commit();
		session.close();
		//����ʵ��User 
		return list;
	}
	
	@Override
	public List<User> listAllUsers()
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery("from User").list();
		session.close();
		return list;
	}

	@Override
	public User findUserById(int id) {
		User user = null;			
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		user = (User) session.get(User.class, id);
		tx.commit();
		session.close();
		return user;
	}
}
