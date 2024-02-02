package com.fikre.restaurant;

import javax.sql.DataSource;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


//@SpringBootApplication
@Configuration
public class CustomConfiguration {
	@Value("${spring.datasource.url}")
	String dbur;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.driver-class-name}")
	String drivername;
	
	@Bean
	@ConditionalOnProperty(name = "use.custom.datasource", havingValue = "true")
    public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(drivername);
		datasource.setUrl(dbur);
		datasource.setUsername(username);
		datasource.setPassword(password);
		
		return datasource;
	}
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
	
}