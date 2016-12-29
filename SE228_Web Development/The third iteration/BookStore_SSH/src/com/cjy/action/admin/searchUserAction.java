package com.cjy.action.admin;

import java.util.List;
import java.util.Map;


import com.cjy.bean.User;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class searchUserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String username;

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(username);
		
		//User taruser = userService.findUserByName(username);
		/*Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("id",taruser.getId());
		session.put("username",taruser.getUsername());
		session.put("password",taruser.getPassword());*/
		
		@SuppressWarnings("unchecked")
		Map<String, List<User>> request = (Map<String,List<User>>) ActionContext.getContext().get("request");
		request.put("list", this.userService.findUserByName(username));	
		
		return SUCCESS;
	}
	
}
