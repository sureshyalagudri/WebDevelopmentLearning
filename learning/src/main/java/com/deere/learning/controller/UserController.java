package com.deere.learning.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deere.learning.domain.User;
import com.deere.learning.service.FileUploadService;
import com.deere.learning.service.UserService;
import com.deere.learning.utils.UploadFileResponse;
import com.deere.learning.view.UserMapping;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	FileUploadService fileUploadService;

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
	public List<User> getAllUsres() {
		return userService.getAllUsers();
	}

	@PostMapping("/adduser")
	public String newUser(@RequestBody UserMapping newUser) throws Exception {
		userService.Register(newUser);
		return "User Added";
	}

	@PostMapping(value = "/addnewuser", produces = "application/json")
	public String addNewUser(
			// @NotNull
			// @Validated
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password) throws Exception {

		System.out.println("Called: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		if (email == null || email.equals("")) {
			return "Email is not valid";
		}

		if (password == null || password.equals("")) {
			return "Password is not valid";
		}

		// How to throw user add issue ?
		UserMapping newUser = new UserMapping();
		userService.Register(newUser);

		return "User added";
	}

	// @PostMapping("/adduser")
	// public void newUser(@ModelAttribute User newUser) {
	// userService.save(newUser);
	// }

	@PostMapping("/upload")
	public UploadFileResponse fileUpload(@RequestParam("file") MultipartFile file) throws Exception {

		System.out.println(file.getName());

		String fileName = fileUploadService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
}
