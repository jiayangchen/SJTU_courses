package com.cjy.action.admin;

import com.cjy.bean.User;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class deleteUserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		this.userService.deleteUser(user);
		return SUCCESS;
	}
	
	
	
}
