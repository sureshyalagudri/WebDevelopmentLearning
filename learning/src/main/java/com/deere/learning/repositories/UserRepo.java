package com.deere.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deere.learning.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByemail(String name);
}