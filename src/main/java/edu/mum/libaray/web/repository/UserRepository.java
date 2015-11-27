package edu.mum.libaray.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.libaray.web.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User,Long>{

}
