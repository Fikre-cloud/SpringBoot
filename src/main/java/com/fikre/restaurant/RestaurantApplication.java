package com.fikre.restaurant;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@SpringBootApplication
@RestController
public class RestaurantApplication {
	@Autowired
	DataSource datasource;
	@Autowired
	CustomService customService;
 
    @GetMapping("/hello")
    public String hello() {
    	try {
			if(datasource.getConnection()!=null) {
//				return " Connected Successfully!";
				System.out.println("Connected Successfully");
				System.out.println("custom service message "+ customService.getMessage());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(customService);
        return "Hello, Spring Boot!" .concat(customService.getMessage());
    }

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
