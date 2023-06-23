package com.example.practica;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"com/example/practica", "templates"})
public class PracticaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}
}