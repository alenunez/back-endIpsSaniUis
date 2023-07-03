package com.Proyecto.BackIpsSaniUis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Proyecto.BackIpsSaniUis")

public class BackIpsSaniUisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackIpsSaniUisApplication.class, args);
	}

}
