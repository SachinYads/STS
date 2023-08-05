package com.prodapt.restfulapp.client;
import java.util.List;

import com.prodapt.restfulapp.model.Book;


public interface BookClient {
	// Retrieve all
	public List<Book> getAllBooks() ;

	// Retrieve by ID
	public Book getBook(Integer bookId);

	// Save Book
	public Book addBook(Book newBook);

	// Retrieve by Book Name
	public Book getBookByName(String bookName) ;

	// Retrieve by publisher
	public List<Book> getBookByPublisher(String publisher);

	// UPDATE Book
	public void updateBook(Book book);

	// Delete book
	public String deleteBookById(Integer bookId);

	// Retrieve by Author
		public List<Book> getBookByAuthor(String author);
}