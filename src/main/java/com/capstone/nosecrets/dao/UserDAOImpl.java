package com.capstone.nosecrets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.capstone.nosecrets.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getUsers() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query 
		Query<User> theQuery = 
				currentSession.createQuery("from User", User.class);
		// execute query and get result list
		List<User> users = theQuery.getResultList();	
		// return the results		
		return users;
	}

	@Override
	public void saveUser(User theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save/upate the user
		currentSession.persist(theUser);
	}

	@Override
	public User getUser(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, theId);
		return theUser;
	}

	@Override
    public void deleteUser(int id) {
        // get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
        // delete
        currentSession.remove(getUser(id));
    }
}