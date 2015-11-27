package edu.mum.libaray.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Authority;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority,Long> {

}
