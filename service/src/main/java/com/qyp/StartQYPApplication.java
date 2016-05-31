package com.qyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qyp.dal.dao.impl.ActivityDaoImpl;

@SpringBootApplication
public class StartQYPApplication implements CommandLineRunner {

	@Autowired
	private ActivityDaoImpl activityDaoImpl;

	public static void main(String[] args) {
		SpringApplication.run(StartQYPApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Start server");
	}
}
