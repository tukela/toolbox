package com.hl.kit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class KitWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitWebApplication.class, args);
	}
}
