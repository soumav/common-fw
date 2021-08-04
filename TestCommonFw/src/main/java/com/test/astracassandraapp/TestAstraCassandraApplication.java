package com.test.astracassandraapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.soumav.*", "com.test.*" })
public class TestAstraCassandraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestAstraCassandraApplication.class, args);
	}

}
