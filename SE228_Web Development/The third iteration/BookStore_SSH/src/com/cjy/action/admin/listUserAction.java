package com.cjy.action.admin;

import java.util.List;
import java.util.Map;

import com.cjy.bean.User;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class listUserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {		
		Map<String, List<User>> request = (Map<String, List<User>>) ActionContext.getContext().get("request");		
		request.put("list", this.userService.listAllUsers());		
		return SUCCESS;
	}
}
