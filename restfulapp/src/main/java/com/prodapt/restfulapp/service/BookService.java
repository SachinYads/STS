package com.prodapt.restfulapp.service;

import java.util.List;
import com.prodapt.restfulapp.entities.Book;
import com.prodapt.restfulapp.exceptions.BookNotFoundException;
public interface BookService {
	// Retrieve all
	public List<Book> getAllBooks() throws BookNotFoundException;
	// Retrieve by ID
	public Book getBook(Integer bookId) throws BookNotFoundException;
	// Save Book
	public Book addBook(Book newBook);
	// Retrieve by Book Name
	public Book getBookByName(String bookName) throws BookNotFoundException;
	// Retrieve by publisher
	public List<Book> getBookByPublisher(String publisher) throws BookNotFoundException;
	// UPDATE Book
	public Book updateBook(Book book) throws BookNotFoundException;

	// Delete book
	public String deleteBookById(Integer bookId) throws BookNotFoundException;

	// Retrieve by Author
		public List<Book> getBookByAuthor(String author) throws BookNotFoundException;
}