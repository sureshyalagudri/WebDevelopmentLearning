package com.deere.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deere.learning.domain.User;
import com.deere.learning.repositories.UserRepo;
import com.deere.learning.view.UserMapping;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void save(UserMapping userMapping) {
		System.out.println("Inside save service");
		User user = new User();
		user.setFirstName(userMapping.getFirstName());
		user.setMiddleName(userMapping.getMiddleName());
		user.setLastName(userMapping.getLastName());
		
		

		userRepo.save(user);
	}

	public void Register(){
		
	}
}
