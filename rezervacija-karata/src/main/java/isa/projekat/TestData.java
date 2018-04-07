package isa.projekat;

import isa.projekat.domain.User;
import isa.projekat.domain.Role;
import isa.projekat.services.UserService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestData {
	
	@Autowired
	private UserService	userService;
	
	@PostConstruct
	private void init(){
	/*	System.out.println("radi li uopste");
		User u1 = new User();
		u1.setCity("Novi Sad");
		u1.setEmail("a@gmail.com");
		u1.setName("Andreja");
		u1.setLastName("Petrovic");
		u1.setUsername("Aki1");
		u1.setPassword("zzz");
		u1.setPhone(666666666);
		u1.setType(UserType.Registered);
		
		userService.addUser(u1);
		
		u1 = new User();
		u1.setCity("Novi Sad");
		u1.setEmail("j@gmail.com");
		u1.setName("Jovana");
		u1.setLastName("Petrovic");
		u1.setUsername("Jovana");
		u1.setPassword("zzz");
		u1.setPhone(111111);
		u1.setType(UserType.Registered);
		
		userService.addUser(u1);*/
	}
}
