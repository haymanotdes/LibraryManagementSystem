package edu.mum.libaray.web.libarary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.entity.Category;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.repository.AuthorRepository;
import edu.mum.libaray.web.repository.BookCopyRepository;
import edu.mum.libaray.web.repository.BookRepository;
import edu.mum.libaray.web.repository.CategoryRepository;
import edu.mum.libaray.web.repository.PublisherRepository;

public class ConfigurationService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookCopyRepository bookCopyRepositroy;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public ConfigurationService(){
		
	}
	
	public void save(Author author){
		authorRepository.save(author);
	}
	public void save(BookCopy bookCopy){
		bookCopyRepositroy.save(bookCopy);
	}
	public void save(Category category){
		categoryRepository.save(category);
	}
	public void save(Publisher publisher){
		publisherRepository.save(publisher);
	}
	public void save(Book book){
		List<Category> categories=new ArrayList<Category>();
		List<Author> authories=new ArrayList<Author>();
		
		for(Long id:book.getCategoriesId()){
			Category category=categoryRepository.findOne(id);
			categories.add(category);
		}
		book.setBookcategory(categories);
		
		for(Long id:book.getAuthoriesId()){
			Author author=authorRepository.findOne(id);
			authories.add(author);
		}
		book.setAuthor(authories);
		bookRepository.save(book);
	}
	
	
	
	public Author findAuthor(long authorid){
		return authorRepository.findOne(authorid);
	}
	public BookCopy findBookCopy(long bookid){
		return  bookCopyRepositroy.findOne(bookid);
	}
	public Category findCategory(long categoryid){
		return categoryRepository.findOne(categoryid);
	}
	public Publisher findPublisher(long publisherid){
		return publisherRepository.findOne(publisherid);
	}
	public Book findBook(long bookid){
		return bookRepository.findOne(bookid);
	}
	
	
	
	public Iterable <Author> findAllAuthors(){
		return authorRepository.findAll();
	}
	public Iterable <BookCopy> findAllBookCopy(){
		return bookCopyRepositroy.findAll();
	}
	public Iterable <Category> findAllCategory(){
		return categoryRepository.findAll();
	}
	public Iterable <Publisher> findPublisher(){
		return publisherRepository.findAll();
	}
	public Iterable <Book> findBook(){
		return  bookRepository.findAll();
	}
	
	
	public void deleteAuthor(long id){
		authorRepository.delete(id);
	}
	public void deleteBookCopy(long id){
		bookCopyRepositroy.delete(id);
	}
	public void deleteCategory(long id){
		categoryRepository.delete(id);
	}
	public void deletePublisher(long id){
		publisherRepository.delete(id);
	}
	public void deleteBook(long id){
		bookRepository.delete(id);
	}
	
	

}
