package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @AllArgsConstructor
public class DemoApplication implements CommandLineRunner {

	Config config;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("test2");
		System.out.println(config.getCookie());
	}
}
