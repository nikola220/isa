package isa.projekat.controller;

import java.io.IOException;

import isa.projekat.domain.User;
import isa.projekat.services.TokenVerificationService;
import isa.projekat.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TokenVerificationService tokenVerificationService;
	
	@Autowired 
	private HttpSession httpSession;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(
			value = "signup",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addUser(@RequestBody User user, HttpServletRequest request) throws Exception {
		if(!user.getPassword().equals(user.getPassword2()))
			return new ResponseEntity<String>("Please enter matching passwords", HttpStatus.BAD_REQUEST);
		
		if(userService.findByEmail(user.getEmail()) != null) {
			return new ResponseEntity<String>("User with that email already exists", HttpStatus.BAD_REQUEST);
		}
		
		userService.addUser(user);
		String verificationUrl = "http://localhost:8080/#!/activation";
		logger.info(verificationUrl);
		tokenVerificationService.createAndSendVerification(user, verificationUrl);
		return new ResponseEntity<String>("User added", HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> loginUser(@RequestBody User loggingUser) throws Exception {
		User user = (User) userService.findByEmailAndPassword(loggingUser.getEmail(), loggingUser.getPassword());
		if(user == null) 
			return new ResponseEntity<String>("User with that email or password doesn't exist", HttpStatus.NOT_FOUND);
		if(!user.isActivated())
			return new ResponseEntity<String>("Your Account hasn't been activated, check your email for account activation", HttpStatus.NOT_FOUND);
		
		httpSession.setAttribute("loggedUser", user);
		return new ResponseEntity<String>(user.getName() + " logged", HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "logout",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> verifyUser(HttpServletResponse response) throws IOException {
		httpSession.invalidate();
		response.sendRedirect("/");
		return new ResponseEntity<String>("User logged out", HttpStatus.CONTINUE);
	}
	
	@RequestMapping(
			value = "details",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getLoggedUser() {
		User user = (User) httpSession.getAttribute("loggedUser");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "activation/{id}",
			method = RequestMethod.POST,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> verifyUser(@PathVariable("id") String id) {
		return tokenVerificationService.verifyEmail(id);
	}
	
	@RequestMapping(
			value = "update",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		Long userId = ((User) httpSession.getAttribute("loggedUser")).getId();
		User updatedUser = userService.updateUser(userId, user);
		httpSession.setAttribute("loggedUser", updatedUser);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
}
