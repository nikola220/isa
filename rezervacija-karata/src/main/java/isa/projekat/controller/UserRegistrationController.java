package isa.projekat.controller;

import isa.projekat.domain.User;
import isa.projekat.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registration")
public class UserRegistrationController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
			value = "addUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
		User addedUser = userService.addUser(user);
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);
	}
}
