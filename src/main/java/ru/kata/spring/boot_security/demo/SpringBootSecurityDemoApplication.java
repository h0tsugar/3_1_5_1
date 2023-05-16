package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://94.198.50.185:7081/api/users";
		System.out.println(restTemplate.getForEntity(url, String.class));
	}
}
