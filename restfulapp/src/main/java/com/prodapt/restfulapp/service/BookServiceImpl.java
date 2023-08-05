package com.prodapt.restfulapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodapt.restfulapp.entities.Book;
import com.prodapt.restfulapp.exceptions.BookNotFoundException;
import com.prodapt.restfulapp.repositories.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;
	@Override
	public List<Book> getAllBooks() throws BookNotFoundException{
		List<Book> books = (List<Book>) bookRepo.findAll();
		if(books != null && !books.isEmpty()) {
			return books;
		}else {
			throw new BookNotFoundException("No books found");
		}

	}
	@Override
	public Book getBook(Integer bookId) throws BookNotFoundException {
		Optional<Book> book = bookRepo.findById(bookId);
		if(book.isPresent()) {
			return book.get();
		}else {
			throw new BookNotFoundException();
		}
		
	}
	@Override
	public Book addBook(Book newBook) {
		return bookRepo.save(newBook);
}
	@Override
	public Book getBookByName(String bookName) throws BookNotFoundException {
		Book book = bookRepo.findByBookName(bookName);
		if(book != null) {
			return book;
		}else {
			throw new BookNotFoundException();
		}
	}
	@Override
	public List<Book> getBookByPublisher(String publisher) throws BookNotFoundException {
		List<Book> books = bookRepo.findByPublisher(publisher);
		if(books != null) {
			return books;
		}else {
			throw new BookNotFoundException();
		}
		}
	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		 if(bookRepo.existsById(book.getBookId())){
			 return bookRepo.save(book);
		 }else {
				throw new BookNotFoundException();
			}
	}
	@Override
	public String deleteBookById(Integer bookId) throws BookNotFoundException {
		if(bookRepo.existsById(bookId)){
			 bookRepo.deleteById(bookId);
			 return "Book with id - "+bookId+ " deleted successfully";
		 }else {
				throw new BookNotFoundException("Book with id - "+bookId+ " not deleted successfully");
			}
		}
	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookRepo.findByAuthor(author);
		if(books != null) {
			return books;
		}else {
			throw new BookNotFoundException();
		}
	}
}
