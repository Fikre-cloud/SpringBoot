package com.fikre.restaurant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		System.out.println("id "+ id);
		Optional<Book> book = bookService.getById(id);
		System.out.println("the book entity "+ book);
		return book.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
  	System.out.println("book details "+ book);
		return bookService.saveBook(book);
	}
	
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }
    
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book){
	System.out.println("book details from update "+ book);
	
	Optional<Book> book1 = bookService.updateBook(id, book);
			return book1.map(ResponseEntity::ok)
					.orElseGet(()->ResponseEntity.notFound().build());
}
	

 }
