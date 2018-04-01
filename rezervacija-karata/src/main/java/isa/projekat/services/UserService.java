package isa.projekat.services;

import isa.projekat.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

	Page<User> findUsers(String criteria, Pageable pageable);
	
	User getUser(String username);
	
	User addUser(User user);
}
