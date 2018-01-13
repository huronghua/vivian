package com.github.vivian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.github.vivian")
@MapperScan("com.github.vivian.repository")
public class VivianApplication {

	public static void main(String[] args) {
		SpringApplication.run(VivianApplication.class, args);
	}
}
