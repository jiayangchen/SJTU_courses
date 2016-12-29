package com.cjy.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.cjy.bean.Order;
import com.cjy.service.OrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class listOrderByUserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
	private int userid;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void listOrderByUser() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		userid = (int) session.get("loginid");
		List<Order> olist = orderService.findOrderByUserId(userid);		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if(olist.size()>0){
			out.print("<table border=\"1\">");
			out.print("<tr><td>订单号</td><td>书号</td><td>数量</td><td>日期</td></tr>");
			for(Order o : olist){
				out.print("<tr>");
		   		out.print("<td>"+o.getOrderid()+"</td>");
		   		out.print("<td>"+o.getBookid()+"</td>");
		   		out.print("<td>"+o.getAmount()+"</td>");
		   		out.print("<td>"+o.getDate()+"</td>");	  
		   		out.print("</tr>");
			}
			out.print("</table>");
		}
		else{
			out.print("出错");
		}
	}
	
}
