package com.cjy.action.statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cjy.bean.User;
import com.cjy.service.OrderService;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class slistUserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private OrderService orderService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void slistUser() throws IOException{
		List<User> ulist = userService.listAllUsers();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if(ulist.size()>0){
			out.print("<table border=\"1\">");
			out.print("<tr><td>ID</td><td>用户名</td><td>密码</td><td>购买量</td><td>总额</td></tr>");
			for(User u : ulist){
				out.print("<tr>");
		   		out.print("<td>"+u.getId()+"</td>");
		   		out.print("<td>"+u.getUsername()+"</td>");
		   		out.print("<td>"+u.getPassword()+"</td>");
		   		out.print("<td>"+orderService.findUsers(u.getId())+"</td>");
		   		out.print("<td>"+orderService.findUsers(u.getId())*15+"</td>");
		   		out.print("</tr>");
			}
			out.print("</table>");
		}
		else{
			out.print("出错");
		}
	}
}
