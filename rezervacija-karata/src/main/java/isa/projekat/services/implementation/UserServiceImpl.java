package isa.projekat.services.implementation;

import isa.projekat.domain.Role;
import isa.projekat.domain.User;
import isa.projekat.repository.UserRepository;
import isa.projekat.services.UserService;

import java.util.Collection;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		Assert.assertNotNull("Kriterijum ne sme biti null", email);
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User addUser(User user) {
		user.setRole(Role.Registered);
		userRepository.save(user);
		return user;
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}

}
