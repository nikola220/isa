package isa.projekat.repository;

import java.util.List;

import isa.projekat.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import java.lang.String;


public interface UserRepository  extends Repository<User, Long> {
	
	Page<User> findAll(Pageable pageable);
	
	List<User> findByUsername(String username);
}
