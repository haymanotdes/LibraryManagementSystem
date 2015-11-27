package edu.mum.libaray.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Category;;

public interface CategoryRepository  extends PagingAndSortingRepository<Category,Long>{

}
