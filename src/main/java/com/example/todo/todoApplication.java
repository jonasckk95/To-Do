package com.example.todo;

import com.example.todo.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableJpaRepositories("com.example.todo.repository")
public class todoApplication {

	public static void main(String[] args) {
		System.out.println("Todo list application has started");
		SpringApplication.run(todoApplication.class, args);

	}
}
