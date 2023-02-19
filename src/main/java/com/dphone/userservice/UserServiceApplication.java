package com.dphone.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//< User Service >

@SpringBootApplication
//@EnableWebSecurity
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("User on duty");
	}

}