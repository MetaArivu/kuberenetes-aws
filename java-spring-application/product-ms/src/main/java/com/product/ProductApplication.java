package com.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProductApplication {

	private final LinkedHashMap<String, String> products = new LinkedHashMap<String, String>();

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/productms");
		SpringApplication.run(ProductApplication.class, args);
	}

	private static final String greetings = "<b>Welcome To Product MS v2</b>";

	private static final String up = "Product MS Is Live!";

	private static final String ready = "Product MS Is Ready!";

	@GetMapping("/")
	public ResponseEntity<String> greetings() {
		System.out.println(new Date() + " | " + greetings);
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

	@GetMapping("/product/")
	public ResponseEntity<LinkedHashMap<String, String>> allProduct() {
		return new ResponseEntity<LinkedHashMap<String, String>>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<LinkedHashMap<String, Object>> getProduct(@PathVariable("id") String id) {
		LinkedHashMap<String, Object> product = new LinkedHashMap<String, Object>();
		product.put("id", id);
		product.put("name", products.get(id));
		product.put("reviews", this.reviews(id));

		return new ResponseEntity<LinkedHashMap<String, Object>>(product, HttpStatus.OK);
	}

	public List<String> reviews(String prdId) {
		List<String> reviews = new ArrayList<String>();

		reviews = restTemplate()
				.getForEntity("http://productreviewms-svc/productreviewms/product/" + prdId + "/review", new ArrayList().getClass())
				.getBody();

		return reviews;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReady() {
		System.out.println("Product MS Ready!");
		System.out.println("DB_USER_NAME=" + System.getenv("DB_USER_NAME"));
		System.out.println("DB_PASSWORD=" + System.getenv("DB_PASSWORD"));
		products.put("1", "IPhone 12");
		products.put("2", "OnePlus");
		products.put("3", "Redmi");
		products.put("4", "Samsung");
		System.out.println("Products=" + products);
	}

}
