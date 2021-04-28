package com.deere.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

	@GetMapping("/listusers")
	public String showUser(){
		System.out.println("Called: " + new Object(){}.getClass().getEnclosingMethod().getName());
		return "user";
	}
	
	@GetMapping("/error")
	public String error(){
		System.out.println("Called: " + new Object(){}.getClass().getEnclosingMethod().getName());
		return "error";
	}
	
	@GetMapping("/Register")
	public String getRegister() {
		System.out.println("Called: " + new Object(){}.getClass().getEnclosingMethod().getName());
		return "Register";
	}

}
