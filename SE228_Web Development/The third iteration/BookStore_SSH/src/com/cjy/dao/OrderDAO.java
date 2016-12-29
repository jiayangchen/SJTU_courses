package com.cjy.dao;

import java.util.List;
import com.cjy.bean.Order;

public interface OrderDAO {
	//DAO����ɾ�Ĳ�ӿ�
	public void addOrder(Order order);
	public List<Order> findOrderByUserId(int userid);
	
	//ͳ��ʱʹ�õĽӿ�
	public int findSales(int bookid);
	public int findUsers(int userid);
	public List<Order> listOrder(String begin , String end);
}
