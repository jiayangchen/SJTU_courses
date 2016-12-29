package com.cjy.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.cjy.bean.Order;
import com.cjy.service.OrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class payOrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int orderid;
	private int bookid;
	private int userid;
	private int amount;
	private String date;
	
	private OrderService orderService;
	
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String execute() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.get("shoppingcart");
		//UserId
		userid = (int) session.get("loginid");
		//Time
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(new Date());
		
		System.out.println("Userid="+userid+"time="+date);
		
		if(cart==null)
		{
			return ERROR;
		}
		
		
		for(int key : cart.keySet())
		{
			System.out.println("key="+key+"amount="+cart.get(key));			
			Order order = new Order();	
			order.setBookid(key);
			order.setUserid(userid);
			order.setAmount(cart.get(key));
			order.setDate(date);			
			orderService.addOrder(order);	
		}
		
		return SUCCESS;
	}
	
}
