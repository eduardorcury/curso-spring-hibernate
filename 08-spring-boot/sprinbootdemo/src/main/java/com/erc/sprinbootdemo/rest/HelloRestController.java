package com.erc.sprinbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World! Server time is: " + LocalDateTime.now();
	}

}
