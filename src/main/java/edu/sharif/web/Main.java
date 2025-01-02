package edu.sharif.web;
	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("edu.sharif.web")	
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
