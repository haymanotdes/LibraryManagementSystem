package edu.mum.libaray.web.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


import edu.mum.libaray.web.entity.BookCopy;

public interface BookCopyRepository extends PagingAndSortingRepository<BookCopy,Long>{
	
	List<BookCopy> findByAvailable(boolean available);
	
	List<BookCopy> findByBookIdAndAvailable(long id,boolean available);

}
