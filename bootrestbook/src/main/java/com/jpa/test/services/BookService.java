package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jpa.test.entities.Books;
@Component
public class BookService {
	
	private static  List<Books> list=new ArrayList();
	
	static {
		list.add(new Books(13,"python complete refrence type","yzx"));
		list.add(new Books(14,"python complete refrence type","xzx"));
		list.add(new Books(12,"web complete refrence type","fyt"));
		
	}
   //get all books
	public List<Books>getAllBooks(){
		
		
		return list;
	}
	
	//get single book by id
	public Books getBooksById(int id) {
		Books book=null;
		
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	public Books addBook(Books b) {
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int bookId)
	{
		list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
	}
}