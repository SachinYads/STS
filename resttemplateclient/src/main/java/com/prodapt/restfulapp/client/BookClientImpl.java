package com.prodapt.restfulapp.client;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prodapt.restfulapp.model.Book;

@Service
public class BookClientImpl implements BookClient {
	@Autowired
	RestTemplate restTemplate;
	final String ROOT_URI = "http://localhost:8082/api/v1/book";
	@Override
	public List<Book> getAllBooks() {
		ResponseEntity<Book[]> response = restTemplate.getForEntity(ROOT_URI+"/allbooks", Book[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public Book getBook(Integer bookId) {
		ResponseEntity<Book> response = restTemplate.getForEntity(ROOT_URI+"/"+bookId, Book.class);
		return response.getBody();
	}

	@Override
	public Book addBook(Book newBook) {
		ResponseEntity<Book> response = restTemplate.postForEntity(ROOT_URI+"/savebook",newBook,Book.class);
		return response.getBody();
	}

	@Override
	public Book getBookByName(String bookName) {
		ResponseEntity<Book> response = restTemplate.getForEntity(ROOT_URI+"/bookname?bookName="+bookName, Book.class);
		return response.getBody();
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) {
		ResponseEntity<Book[]> response = restTemplate.getForEntity(ROOT_URI+"/publisher?publisher="+publisher, Book[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public void updateBook(Book book) {
			restTemplate.put(ROOT_URI+"/updatebookdetails",book);
	}

	@Override
	public String deleteBookById(Integer bookId) {
		ResponseEntity<String> response = restTemplate.getForEntity(ROOT_URI+"/deletebookbyid"+bookId, String.class);
		return response.getBody();
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		ResponseEntity<Book[]> response = restTemplate.getForEntity(ROOT_URI+"/author?author="+author, Book[].class);
		return Arrays.asList(response.getBody());
	}

	

}