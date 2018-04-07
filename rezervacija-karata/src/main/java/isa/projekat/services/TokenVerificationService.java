package isa.projekat.services;

import isa.projekat.domain.User;

import org.springframework.http.ResponseEntity;

public interface TokenVerificationService {

	void createAndSendVerification(User user, String url);
	
	ResponseEntity<String> verifyEmail(String token);
	
}
