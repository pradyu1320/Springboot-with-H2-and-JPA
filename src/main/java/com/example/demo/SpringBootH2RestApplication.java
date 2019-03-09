package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@SpringBootApplication
public class SpringBootH2RestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2RestApplication.class, args);
	}
	

}
