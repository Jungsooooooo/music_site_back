package com.music.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MusicSiteApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MusicSiteApplication.class);
		app.run(args);
	}

}
