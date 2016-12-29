package com.cjy.service;

import java.util.List;

import com.cjy.bean.User;


public interface UserService {
	
	//Service��ӿ�
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> findUserByName(String name);
	public User findUserById(int id);
	public List<User> listAllUsers();	
	
	//�ж��Ƿ�Ϊ����Ա�����û�
	public boolean ifUser(String username, String pwd);	
	public boolean ifAdmin(String username, String pwd);	

	
}
