package com.fikre.restaurant;

//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fikre.restaurant.Calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTests {
    Calculator cal = new Calculator();
    
    @Test
    public void add() {
    int result = cal.add(1,2);
    assertEquals(3,result);
    }
    
    @Test
    public void sub() {
    	int result = cal.sub(2,1);
    	assertEquals(1,result);
    }
    
    @Test
    public void mut() {
    	int result = cal.mut(3,2);
    	assertEquals(6,result);
    }
    
    @Test
    public void div() {
    	int result = cal.div(6,3);
    	assertEquals(2,result);
    }

}
