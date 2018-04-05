package isa.projekat.controller;

import java.security.Principal;
import java.util.Collection;

import isa.projekat.domain.User;
import isa.projekat.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registration")
public class UserRegistrationController {
	
	@Autowired
	UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(
			value = "signup",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
		if(!user.getPassword().equals(user.getPassword2()))
			return new ResponseEntity<String>("Please enter matching passwords", HttpStatus.BAD_REQUEST);
		
		if(userService.findByEmail(user.getEmail()) != null) {
			return new ResponseEntity<String>("User with that email already exists", HttpStatus.BAD_REQUEST);
		}
		
		userService.addUser(user);
		return new ResponseEntity<String>("User added", HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> loginUser(@RequestBody User user, Principal principal) throws Exception {
		User logged = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		return new ResponseEntity<String>(logged.getName() + " logged", HttpStatus.CREATED);
	}
}
