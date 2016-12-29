package com.cjy.action.admin;

import java.util.Map;

import com.cjy.bean.User;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class saveUserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	@Override
	public String execute() throws Exception {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//对于注册成功的用户存下用户名以便于转发至register.jsp页面时显示
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("login", username);
		
		userService.addUser(user);
		return SUCCESS;
	}
	
}
