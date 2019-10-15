package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan({"com.telusko.service","com.telusko.dao",
	"com.telusko.model","com.telusko.demo"})//to scan repository files

//@EntityScan("com.telusko.dao.UserDao")
//@EnableJpaRepositories("com.example.repositories")
public class MyWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}
