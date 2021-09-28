package com.helloworld;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
	
	private static final String greetings = "<b>Welcome to HelloWorld v3</b>";
	
	private static final String up = "Helloworld Application Is UP!";
	
	private static final String ready = "Helloworld Application Is READY!";

	@GetMapping("/")
	public ResponseEntity<String> greetings(){
		System.out.println(new Date()+" | "+greetings);
		System.out.println("DB_USER_NAME="+System.getenv("DB_USER_NAME"));
		System.out.println("DB_PASSWORD="+System.getenv("DB_PASSWORD"));
		return new ResponseEntity<String>(greetings, HttpStatus.OK);
	}

	@GetMapping("/live")
	public ResponseEntity<String> liveness(){
		System.out.println(new Date()+" | "+up);
		return new ResponseEntity<String>(up, HttpStatus.OK);
	}
	
	@GetMapping("/readiness")
	public ResponseEntity<String> readiness(){
		System.out.println(new Date()+" | "+ready);
		return new ResponseEntity<String>(ready, HttpStatus.OK);
	}
	
}
