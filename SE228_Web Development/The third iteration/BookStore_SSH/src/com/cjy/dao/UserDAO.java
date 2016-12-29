package com.cjy.dao;
import java.util.List;

import com.cjy.bean.User;

public interface UserDAO {
	
	//DAO����ɾ�Ĳ�ӿ�
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> findUserByName(String name);
	public User findUserById(int id);
	//�г������û�
	public List<User> listAllUsers();
	
}
