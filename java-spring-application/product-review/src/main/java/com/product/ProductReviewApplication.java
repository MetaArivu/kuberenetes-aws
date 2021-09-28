package com.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.context.event.ApplicationReadyEvent;

@SpringBootApplication
@RestController
public class ProductReviewApplication {

	private final LinkedHashMap<String, List<String>> products = new LinkedHashMap<String, List<String>>();

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/productreviewms");
		SpringApplication.run(ProductReviewApplication.class, args);
	}

	private static final String greetings = "<b>Welcome To Product Review MS v1</b>";

	private static final String up = "Product Review MS Is Live!";

	private static final String ready = "Product Review MS Is Ready!";

	@GetMapping("/")
	public ResponseEntity<String> greetings() {
		return new ResponseEntity<String>(greetings, HttpStatus.OK);
	}

	@GetMapping("/live")
	public ResponseEntity<String> liveness() {
		return new ResponseEntity<String>(up, HttpStatus.OK);
	}

	@GetMapping("/readiness")
	public ResponseEntity<String> readiness() {
		return new ResponseEntity<String>(ready, HttpStatus.OK);
	}

	@GetMapping("/product/{id}/review")
	public ResponseEntity<List<String>> productReview(@PathVariable("id") String id) {
		return new ResponseEntity<List<String>>(products.get(id), HttpStatus.OK);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void applicationReady() {
		System.out.println("Product Review MS Ready!");
		System.out.println("DB_USER_NAME=" + System.getenv("DB_USER_NAME"));
		System.out.println("DB_PASSWORD=" + System.getenv("DB_PASSWORD"));
		products.put("1", Arrays.asList("IPhone Review 1", "IPhone Review 2"));
		products.put("2", Arrays.asList("OnePlus Review 1", "OnePlus Review 2"));
		products.put("3", Arrays.asList("Redmi Review 1", "Redmi Review 2"));
		products.put("4", Arrays.asList("Samsung Review 1"));
		System.out.println("Products="+products);
	}

}
