package com.cjy.dao;

import java.util.List;
import com.cjy.bean.Order;

public interface OrderDAO {
	//DAO的增删改查接口
	public void addOrder(Order order);
	public List<Order> findOrderByUserId(int userid);
	
	//统计时使用的接口
	public int findSales(int bookid);
	public int findUsers(int userid);
	public List<Order> listOrder(String begin , String end);
}
