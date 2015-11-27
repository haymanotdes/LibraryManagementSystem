package edu.mum.libaray.web.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Fine;

public interface FineRepository extends PagingAndSortingRepository<Fine,Long>{
	
	List<Fine> findByBorrowUserId(long userid);

}
