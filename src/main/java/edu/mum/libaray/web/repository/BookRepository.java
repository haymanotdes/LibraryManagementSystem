package edu.mum.libaray.web.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Book;



public interface BookRepository extends PagingAndSortingRepository<Book,Long>{
	
	
	 List<Book> findByIsbn(String isbn);
	 List<Book> findByNameLike(String Name);
	 List<Book> findByAuthorFnameOrAuthorLname(String fname,String lname);
	 List<Book> findByBookcategoryName(String categoryName);
	 List<Book> findByPublisherName(String publisherName);
	 List<Book> findByPublisherId(Long publisher);
	 List<Book> findByAuthorId(Long author);
	 List<Book> findByNameLikeOrPublisherIdOrAuthorId(
			 String Name,
			 Long publisher,
			 Long author);
	 
	 List<Book> findByNameLikeAndPublisherIdAndAuthorId(
			 String Name,
			 Long publisher,
			 Long author);
	 
	 List<Book> findByNameLikeAndPublisherId(
			 String Name,
			 Long publisher);
	 
	 List<Book> findByNameLikeAndAuthorId(
			 String Name,
			 Long author);
	 
	
	 
	 
	 

}
