package com.capstone.nosecrets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.nosecrets.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    // I dont need any DAO. this gives me all methods out of the box
}
