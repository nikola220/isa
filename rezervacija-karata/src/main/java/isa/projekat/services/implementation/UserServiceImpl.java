package isa.projekat.services.implementation;

import isa.projekat.domain.User;
import isa.projekat.domain.UserType;
import isa.projekat.repository.UserRepository;
import isa.projekat.services.UserService;

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
	public User addUser(User user) {
		user.setType(UserType.Registered);
		userRepo.save(user);
		return user;
	}

}
