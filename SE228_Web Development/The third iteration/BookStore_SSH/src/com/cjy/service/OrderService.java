package com.cjy.service;


import java.util.List;

import com.cjy.bean.Order;

public interface OrderService {
	public void addOrder(Order order);
	public List<Order> findOrderByUserId(int userid);
	
	//ͳ��ʱ��Service�ӿ�
	public int findSales(int bookid);
	public int findUsers(int userid);
	public List<Order> listOrder(String begin, String end);
}
