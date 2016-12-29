package com.cjy.dao;
import java.util.List;

import com.cjy.bean.User;

public interface UserDAO {
	
	//DAO的增删改查接口
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> findUserByName(String name);
	public User findUserById(int id);
	//列出所有用户
	public List<User> listAllUsers();
	
}
