package com.cjy.service.impl;

import java.util.List;

import com.cjy.bean.Order;
import com.cjy.dao.OrderDAO;
import com.cjy.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	public OrderServiceImpl(){}
	
	private OrderDAO orderDAO;

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public void addOrder(Order order) {
		this.orderDAO.addOrder(order);
	}
	@Override
	public List<Order> findOrderByUserId(int userid) {
		return this.orderDAO.findOrderByUserId(userid);
	}	
	@Override
	public int findSales(int bookid) {
		return this.orderDAO.findSales(bookid);
	}

	@Override
	public int findUsers(int userid) {
		return this.orderDAO.findUsers(userid);
	}

	@Override
	public List<Order> listOrder(String begin, String end) {
		return this.orderDAO.listOrder(begin, end);
	}
}
