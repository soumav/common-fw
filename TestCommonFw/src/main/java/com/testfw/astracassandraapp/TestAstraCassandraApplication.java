package com.testfw.astracassandraapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.commonfw.*", "com.testfw.astracassandraapp.*" })
public class TestAstraCassandraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestAstraCassandraApplication.class, args);
	}

}
