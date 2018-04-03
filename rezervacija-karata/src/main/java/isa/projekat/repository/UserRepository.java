package isa.projekat.repository;

import isa.projekat.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {
	
	User findByNameAndLastNameAllIgnoringCase(String name, String lastName);
}
