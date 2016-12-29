package com.cjy.bean;

public class Order {
	private int orderid;
	private int bookid;
	private int userid;
	private int amount;
	private String date;
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
	public void setDate(String time) {
		this.date = time;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", bookid=" + bookid + ", userid=" + userid + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	
	
}
