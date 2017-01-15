package com.arya.myapp.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.arya.myapp" })
public class SpringBootCongfiguration {
	
	static{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    System.setProperty("current.date", dateFormat.format(new Date()));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCongfiguration.class, args);
	}
	
}
