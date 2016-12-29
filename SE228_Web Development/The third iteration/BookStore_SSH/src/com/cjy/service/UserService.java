package com.cjy.service;

import java.util.List;

import com.cjy.bean.User;


public interface UserService {
	
	//Service层接口
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> findUserByName(String name);
	public User findUserById(int id);
	public List<User> listAllUsers();	
	
	//判断是否为管理员或者用户
	public boolean ifUser(String username, String pwd);	
	public boolean ifAdmin(String username, String pwd);	

	
}
