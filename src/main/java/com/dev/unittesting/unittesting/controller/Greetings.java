package com.dev.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetings {
	
	@GetMapping("/greetings")
	public String initialGreetings() {
		return "Greetings!!!";
	}
	
}
