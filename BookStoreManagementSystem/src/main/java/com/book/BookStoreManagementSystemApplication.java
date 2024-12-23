package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.book")
public class BookStoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementSystemApplication.class, args);
		
		System.out.println("running");
	}

}
