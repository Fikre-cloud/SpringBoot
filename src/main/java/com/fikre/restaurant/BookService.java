package com.fikre.restaurant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
   @Autowired
   BookRepository bookRepository;
   
   public Optional<Book> getById(Long id) {
	   //@Query ("select * from Book_tbl where id="+id)
	   return bookRepository.findById(id);
   }
   
   public Book saveBook(Book book) {
	   return bookRepository.save(book);
   }
   
   public void deleteBook(Long id) {
	   bookRepository.deleteById(id);
   }
   
   public Optional<Book> updateBook(Long id, Book book) {
	   return bookRepository.findById(id)
			   .map(book1->{
				   book1.setTitle(book.getTitle());
				   book1.setAuthor(book.getAuthor());
				   book1.setPublishedDate(book.getPublishedDate());
				   return bookRepository.save(book1);
			   });
   }
   

}
