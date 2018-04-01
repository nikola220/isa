package isa.projekat.services;

import isa.projekat.domain.User;
import isa.projekat.repository.UserRepository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public Page<User> findUsers(String criteria, Pageable pageable) {
		Assert.assertNotNull("Kriterijum ne sme biti null", criteria);
		return userRepo.findAll(pageable);
	}

	@Override
	public User getUser(String username) {
		return null;
	}

	@Override
	public User addUser(User user) {
		User u = new User();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setCity(user.getCity());
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		u.setPhone(user.getPhone());
		return u;
	}

}
