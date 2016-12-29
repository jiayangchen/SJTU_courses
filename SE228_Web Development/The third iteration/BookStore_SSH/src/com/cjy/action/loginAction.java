package com.cjy.action;

import java.util.Map;

import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	private UserService userService;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute(){
		//µ÷ÊÔÐÅÏ¢
		System.out.println(username + ":" + password);		
		
		if (userService.ifUser(username, password)==true){
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("login",username);
			return SUCCESS;
		}
		else if(userService.ifAdmin(username, password)==true){
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("login",username);
			return ERROR;
		}	
		
		return LOGIN;
		
	}
	
}
