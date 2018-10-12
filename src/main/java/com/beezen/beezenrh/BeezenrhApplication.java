package com.beezen.beezenrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages={"com.beezenrh.service","com.beezenrh.service.impl","com.beezenrh.controller","com.beezenrh.exeption","com.beezenrh.domain","com.beezenrh.repository"})
public class BeezenrhApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeezenrhApplication.class, args);
	}
}
