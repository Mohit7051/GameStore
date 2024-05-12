package com.itvedant.gamestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@ComponentScan(basePackages = "com.itvedant.gamestore")
@EnableConfigurationProperties({GameStoreStorageProperties.class})
public class GameStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}

}
