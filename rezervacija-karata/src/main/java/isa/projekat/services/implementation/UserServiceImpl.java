package isa.projekat.services.implementation;

import isa.projekat.domain.User;
import isa.projekat.domain.UserType;
import isa.projekat.repository.UserRepository;
import isa.projekat.services.UserService;

import java.util.Collection;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByEmail(String email) {
		Assert.assertNotNull("Kriterijum ne sme biti null", email);
		User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public User addUser(User user) {
		user.setType(UserType.Registered);
		userRepo.save(user);
		return user;
	}

	@Override
	public Collection<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		User user = userRepo.findByEmailAndPassword(email, password);
		return user;
	}

	@Override
	public User getLoggedUser() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 User logged = userRepo.findById((Long) auth.getPrincipal());
		 return logged;
	}


}
