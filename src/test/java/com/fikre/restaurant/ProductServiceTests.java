package com.fikre.restaurant;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTests {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	
	@Test
	public void createProduct() {
		Product product = new Product();
		product.setName("pencil");
		product.setPrice(5.99);
		
		Product result = productService.createProduct(product);
		assertEquals("pencil",result.getName());
			
		}
	@Test
	public void getProductById() {
		Optional<Product> result = productService.getProductById(8L);
		assertEquals("pencil",result.get().getName());
	}

	}

