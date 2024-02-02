package com.fikre.restaurant;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("morning message")
@Profile("dev")
public class GreetingService implements GreetingsInterface{
	
	public String getGreetings() {
		return "Morning Greetings from service";
	}

}
