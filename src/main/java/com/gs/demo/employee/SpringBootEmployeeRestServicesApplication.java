package com.gs.demo.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
 
public class SpringBootEmployeeRestServicesApplication{
	private static final Logger log = LoggerFactory.getLogger(SpringBootEmployeeRestServicesApplication.class);
	private static final String CLASS_NAME="SpringBootEmployeeRestServicesApplication :: ";
	private static String METHOD_NAME="";
	private static final String ENTRY="::  Entry";
	private static final String EXIT=":: Exit";
	
	public static void main(String[] args) {
		METHOD_NAME="main";
		log.info(CLASS_NAME+METHOD_NAME+ENTRY);
		SpringApplication.run(SpringBootEmployeeRestServicesApplication.class, args);
		log.info(CLASS_NAME+METHOD_NAME+EXIT);


	}
	
	
	
}
