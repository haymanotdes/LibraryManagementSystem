package edu.mum.libaray.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Borrow;

public interface BorrowRepository extends PagingAndSortingRepository<Borrow,Long>{
	
	List<Borrow> findByUserIdOrTakeDateOrReturnDateOrBookCopyBookNameLike(
			long userid,
			Date takeDate,
			Date returnDate,
			String bookName);
	
	List<Borrow> findByReturned(Boolean returned);
	
	List<Borrow> findByUserId(
			long userid);

}
