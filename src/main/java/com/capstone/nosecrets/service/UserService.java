package com.capstone.nosecrets.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.capstone.nosecrets.dto.UserSecret;
import com.capstone.nosecrets.entity.User;

public interface UserService {
	@Transactional
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);
	
	public void deleteUser(int id);

	public void updateUser(int id, UserSecret secret);
	
}
