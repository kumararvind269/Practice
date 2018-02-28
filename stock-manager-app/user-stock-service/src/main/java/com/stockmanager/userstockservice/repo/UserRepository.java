package com.stockmanager.userstockservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmanager.userstockservice.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByName(String name);
	
}
