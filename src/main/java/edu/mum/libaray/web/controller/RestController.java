package edu.mum.libaray.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.libaray.web.dto.AuthorDTO;
import edu.mum.libaray.web.dto.BookDTO;
import edu.mum.libaray.web.dto.PublisherDTO;
import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.repository.AuthorRepository;
import edu.mum.libaray.web.repository.BookRepository;
import edu.mum.libaray.web.repository.PublisherRepository;

//import edu.mum.libaray.web.libarary.service.*;

@Controller
public class RestController {

	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@RequestMapping(value="/rest/book/{name}",method=RequestMethod.GET)
	public @ResponseBody String findBook(@PathVariable("name") String name){
		//ToDo go to add page
		
		//System.out.println("_libararyService: "+_libararyService.getAnything());
		
		return "hdjhjshdj";
		
	}
	
	
	@RequestMapping(value="/rest/booksssssss",method=RequestMethod.GET)
	public ResponseEntity<List<Book>> listBook()
	//public @ResponseBody List<Book> listBook()
	
	{
		//ToDo go to add page
		
		ResponseEntity ss;
//		Iterable<Book> iterable=bookRepository.findAll();
//		List<Book> list=new ArrayList<Book>();
//		
//		for(Book book: iterable) {
//	        list.add(book);
//	      }
//		
//		return Collections.unmodifiableList(list).toArray();
		List<Book> books=bookRepository.findByIsbn("464545445");
		//return bookRepository.findByIsbn("464545445");
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		
		//System.out.println("_libararyService: "+_libararyService.getAnything());
//		List<String> ss=new ArrayList<String>();
//		ss.add("one");
//		ss.add("two");
//		ss.add("three");
//		return ss;
		
	}
	
	@RequestMapping(value="/rest/books",method=RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> listBooks()
	
	
	{
		//ToDo go to add page
		List<BookDTO> bookDTOList=new ArrayList<BookDTO>();
		
		
		Iterable<Book> books=bookRepository.findAll();
		
		
		for(Book book: books){
			
			BookDTO bookDTO=new BookDTO();
			bookDTO.setName(book.getName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPublisher(book.getPublisher().getName());
			
			for(Author author : authorRepository.findByBookId(book.getId()) ){
				
				bookDTO.getAuthor().add(author.getFname()+" "+author.getLname());
				
			}
			
			
			bookDTOList.add(bookDTO);
		}
		
		return new ResponseEntity<List<BookDTO>>(bookDTOList, HttpStatus.OK);
		
	
		
	}
	
	@RequestMapping(value="/rest/publishers",method=RequestMethod.GET)
	public ResponseEntity<List<PublisherDTO>> listPublishers()
	
	
	{
		//ToDo go to add page
		List<PublisherDTO> publisherDTOList=new ArrayList<PublisherDTO>();
		
		
		Iterable<Publisher> publishers=publisherRepository.findAll();
		
		
		for(Publisher publisher: publishers){
			
			PublisherDTO publisherDTO=new PublisherDTO();
			publisherDTO.setName(publisher.getName());
			publisherDTO.setPhone(publisher.getPhone());
			publisherDTO.setFax(publisher.getFax());
			publisherDTO.setUrl(publisher.getUrl());
			
			publisherDTOList.add(publisherDTO);
		}
		
		return new ResponseEntity<List<PublisherDTO>>(publisherDTOList, HttpStatus.OK);
		
	
		
	}
	
	
	@RequestMapping(value="/rest/authors",method=RequestMethod.GET)
	public ResponseEntity<List<AuthorDTO>> listAuthors()
	
	
	{
		//ToDo go to add page
		List<AuthorDTO> authorDTOList=new ArrayList<AuthorDTO>();
		
		
		Iterable<Author> authors=authorRepository.findAll();
		
		
		for(Author author: authors){
			
			AuthorDTO authoDTO=new AuthorDTO();
			authoDTO.setFname(author.getFname());
			authoDTO.setLname(author.getLname());
			authoDTO.setPhone(author.getPhone());
			authoDTO.setEmail(author.getEmail());
			
			authorDTOList.add(authoDTO);
		}
		
		return new ResponseEntity<List<AuthorDTO>>(authorDTOList, HttpStatus.OK);
		
	
		
	}
	
	
	
	@RequestMapping(value="/rest/book/all",method=RequestMethod.GET)
	public ResponseEntity<Iterable<Book>> getAllBooks()
	//public @ResponseBody List<Book> listBook()
	
	{
		//ToDo go to add page
		
		//ResponseEntity ss;
//		Iterable<Book> iterable=bookRepository.findAll();
//		List<Book> list=new ArrayList<Book>();
//		
//		for(Book book: iterable) {
//	        list.add(book);
//	      }
//		
//		return Collections.unmodifiableList(list).toArray();
		Iterable<Book> books=bookRepository.findAll();
		
		return new ResponseEntity<Iterable<Book>>(books, HttpStatus.OK);
		
		//System.out.println("_libararyService: "+_libararyService.getAnything());
//		List<String> ss=new ArrayList<String>();
//		ss.add("one");
//		ss.add("two");
//		ss.add("three");
//		return ss;
		
	}
}
