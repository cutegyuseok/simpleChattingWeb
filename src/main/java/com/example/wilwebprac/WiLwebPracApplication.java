package com.example.wilwebprac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.wilwebprac.mapper"})
public class WiLwebPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiLwebPracApplication.class, args);
	}

}
