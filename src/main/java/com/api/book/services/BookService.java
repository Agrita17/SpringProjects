package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
@Service
public class BookService {

	/*
	 * private static List<Book> bookList = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * bookList.add(new Book(12,"Java Course","Agrita")); bookList.add(new
	 * Book(13,"Python Course","Shivi")); bookList.add(new
	 * Book(14,"Php Course","Tanu"));
	 * 
	 * }
	 */
	@Autowired
	private BookRepository bookRepository;
	
	//getAll Method
	public List<Book> getAllBooks()
	{
		List<Book> bookList = (List<Book>) this.bookRepository.findAll();
		return bookList;
	}
	
	//get book by id
	public Book getBookById(int id)
	{
		Book book = null;
		book = this.bookRepository.findById(id);
  //bookList.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//createBook method
	public Book createBook(Book b)
	{
		//bookList.add(b);
		this.bookRepository.save(b);
		return b;
	}
	
	//Deteling Book
	public String deleteBook(int id)
	{
		//bookList = bookList.stream().filter(book -> book.getId()!=id ).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
		return "Book Deleted";
	}
	
	//updating book
	public void updateBook(Book book, int id)
	{
		/*
		 * bookList = bookList.stream().map(b ->{ if(b.getId()==id) {
		 * b.setAuthor(book.getAuthor()); b.setTitle(book.getTitle()); } return b;
		 * }).collect(Collectors.toList());
		 */
		
		this.bookRepository.save(book);
	}
	
	
	
	
	
	
}
