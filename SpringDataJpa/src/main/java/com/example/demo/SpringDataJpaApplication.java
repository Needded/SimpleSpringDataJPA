package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.*;
import com.example.demo.name.ConsoleHandler;
import com.example.demo.name.NamesService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.name")
public class SpringDataJpaApplication {

	@Autowired
    private ConsoleHandler consoleHandler;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	
	}
		@PostConstruct
	    public void init() {
	        consoleHandler.handler();
	    }
		 
		

}
