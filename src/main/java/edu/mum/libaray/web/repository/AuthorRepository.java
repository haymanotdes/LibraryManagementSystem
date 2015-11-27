package edu.mum.libaray.web.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Author;


public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
	
	List<Author> findByBookId(Long bookid);

}
