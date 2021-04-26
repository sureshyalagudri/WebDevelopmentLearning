package com.deere.learning.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deere.learning.domain.User;
import com.deere.learning.service.UserService;
import com.deere.learning.view.UserMapping;
import com.sun.istack.NotNull;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// @RequestMapping(value = "/users", method={RequestMethod.GET})
	@GetMapping("/users")
	public List<String> getListOfUsers() {
		return Arrays.asList("aaa", "bbbb");
	}

	@GetMapping("/Role")
	public String getRole() {
		return "Admin";
	}

	@GetMapping("/allusers")
	public List<String> getAllUsres() {
		userService.getAllUsers();
		return null;
	}

	@PostMapping("/adduser")
	public String newUser(@RequestBody UserMapping newUser) {
		userService.save(newUser);

		return "User Added";
	}

	@PostMapping("/addnewuser")
	public String addNewUser(
			// @NotNull
			// @Validated
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password) {

		if (email == null || email.equals("")) {
			return "Email is not valid";
		}

		if (password == null || password.equals("")) {
			return "Password sis not valid";
		}

		return "User added";
	}

	// @PostMapping("/adduser")
	// public void newUser(@ModelAttribute User newUser) {
	// userService.save(newUser);
	// }
}
