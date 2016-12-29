package com.cjy.service.impl;

import java.util.List;
import java.util.Map;

import com.cjy.bean.User;
import com.cjy.dao.UserDAO;
import com.cjy.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(){}
	
	
	private UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//Service�߼���ʵ��
	public void addUser(User user) {
		this.userDAO.addUser(user);
	}
	
	public void deleteUser(User user){	
		this.userDAO.deleteUser(user);
	}
	
	public void updateUser(User user){
		this.userDAO.updateUser(user);
	}
	
	public List<User> findUserByName(String name){
		return this.userDAO.findUserByName(name);
	}
	
	public User findUserById(int id){
		return this.userDAO.findUserById(id);
	}
	
	public List<User> listAllUsers(){
		return this.userDAO.listAllUsers();
	}
	
	//�ж��ǲ����û�
	public boolean ifUser(String username, String pwd){
		
		List<User> userBuf = (List<User>) userDAO.findUserByName(username);
		boolean tag = false;
		for(User u:userBuf)
		{
			if((u.getUsername()).equals(username) && (u.getPassword()).equals(pwd)){
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("loginid", u.getId());
				tag = true;
				break;
			}
		}
		return tag;
		
	}
	
	//�ж��ǲ��ǹ���Ա
	public boolean ifAdmin(String username, String pwd){
		//���ж��ǲ����ҵ�ѧ�ź�����
		String tarname = "5140379036";
		String tarpwd = "root";
		if(username.equals(tarname) && pwd.equals(tarpwd))
			return true;
		else
			return false;
	}
	
}
