package com.capstone.nosecrets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.nosecrets.dao.UserDAO;
import com.capstone.nosecrets.dto.UserSecret;
import com.capstone.nosecrets.entity.User;
// import com.capstone.nosecrets.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	// @Autowired
	// private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		// userRepository.findById(null)
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	@Transactional
	public void updateUser(int id, UserSecret secret) {
		User user = getUser(id);
		user.setSecret(secret.getSecret());
		userDAO.saveUser(user);
	}
}