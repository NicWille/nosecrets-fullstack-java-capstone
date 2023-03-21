package com.capstone.nosecrets.dao;

import java.util.List;

import com.capstone.nosecrets.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);
	
	public void deleteUser(int id);
	
}
