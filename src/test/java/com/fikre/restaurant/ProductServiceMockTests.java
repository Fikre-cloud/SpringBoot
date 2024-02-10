package com.fikre.restaurant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Use this if you are using JUnit 5
public class ProductServiceMockTests {
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	ProductService productService;

	@Test
	public void createProduct() {
		Product product = new Product();
		product.setName("book");
		product.setPrice(56.89);
		
		when(productRepository.save(product)).thenReturn(product); // mocking happening here
		
		Product result = productService.createProduct(product);
		assertEquals("book",result.getName());
	}
}
