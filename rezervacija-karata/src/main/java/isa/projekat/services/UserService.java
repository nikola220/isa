package isa.projekat.services;

import isa.projekat.domain.User;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
	
	User addUser(User user);

	Collection<User> findAll();
	
}
