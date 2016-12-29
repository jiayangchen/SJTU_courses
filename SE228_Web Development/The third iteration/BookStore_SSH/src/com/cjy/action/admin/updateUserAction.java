package com.cjy.action.admin;

import java.util.Map;

import com.cjy.bean.User;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateUserAction extends ActionSupport{
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
		System.out.println(user.getId()+" "+user.getUsername()+" "+user.getPassword());
		user.setId(user.getId());
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
				
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("id",user.getId());
		session.put("username",user.getUsername());
		session.put("password",user.getPassword());

		this.userService.updateUser(this.user);
		return SUCCESS;
	}
	
}
