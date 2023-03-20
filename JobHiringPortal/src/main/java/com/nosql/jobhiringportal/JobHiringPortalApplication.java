package com.nosql.jobhiringportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.nosql.jobhiringportal.controller")
@ComponentScan("com.nosql.jobhiringportal.*")
public class JobHiringPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobHiringPortalApplication.class, args);
	}

}
