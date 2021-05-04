package com.deere.learning.service;

import java.sql.Date;
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

	public void Register(UserMapping userMapping) throws Exception {
		System.out.println("Inside Register service");

		// Check if user found already.
		if (userRepo.findByemail(userMapping.getEmail()) != null) {
			throw new Exception("User already present!");
		}

		User user = new User();
		user.setEmail(userMapping.getEmail());
		user.setPassword(userMapping.getPassword());

		Date date = new Date(System.currentTimeMillis());

		// Set dummy value for other required data.
		user.setFirstName("");
		user.setMiddleName("");
		user.setLastName("");
		user.setBirthDate(date);
		user.setCountry("");
		user.setRole("Normal");
		user.setPhone(0000000000);
		user.setAddress("");
		user.setGender("");

		userRepo.save(user);
	}
}
