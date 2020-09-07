package com.erc.sprinbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World! Server time is: " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run 5 miles";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach Name: " + coachName + ", Team Name: " + teamName;
	}

}






