package com.hl.kit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hl.kit.data")
public class KitWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitWebApplication.class, args);
	}
}
