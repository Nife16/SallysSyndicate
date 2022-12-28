package com.mopar.syndicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mopar")
public class SyndicateApplication {
	public static void main(String[] args) {
		SpringApplication.run(SyndicateApplication.class, args);
	}

}
