package com.fikre.restaurant;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomServiceConfiguration {
	@Bean
	@ConditionalOnProperty(name="use.custom.override", havingValue="true")
	public CustomService customService() {
		return new CustomService();
	}

}
