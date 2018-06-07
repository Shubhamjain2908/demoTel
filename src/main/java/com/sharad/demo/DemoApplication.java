package com.sharad.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sharad.demo.dao")
@EntityScan("com.sharad.demo.vo")
public class DemoApplication implements CommandLineRunner{
	 @Autowired
	 DataSource dataSource;
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("*****HIIHi**");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Our DataSource is = " + dataSource);
		
		
	}
}
