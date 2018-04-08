package isa.projekat.services.implementation;

import isa.projekat.domain.User;
import isa.projekat.domain.VerificationToken;
import isa.projekat.repository.TokenVerificationRepository;
import isa.projekat.repository.UserRepository;
import isa.projekat.services.EmailService;
import isa.projekat.services.TokenVerificationService;
import isa.projekat.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenVerificationServiceImpl implements TokenVerificationService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	TokenVerificationRepository tokenVerificationRepository;
	
	@Autowired
	UserService userService;

	@Override
	public void createAndSendVerification(User user, String url) {
        List<VerificationToken> verificationTokens = tokenVerificationRepository.findByUserEmail(user.getEmail());
        VerificationToken verificationToken;
        if (verificationTokens.isEmpty()) {
            verificationToken = new VerificationToken();
            verificationToken.setUser(user);
            tokenVerificationRepository.save(verificationToken);
        } else {
            verificationToken = verificationTokens.get(0);
        }

        emailService.sendEmail(user.getEmail(), verificationToken.getToken(), url.concat("/" + verificationToken.getToken()));
	}

	@Override
	public ResponseEntity<String> verifyEmail(String token) {
        List<VerificationToken> verificationTokens = tokenVerificationRepository.findByToken(token);
        if (verificationTokens.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid token.");
        }

        VerificationToken verificationToken = verificationTokens.get(0);
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
            return ResponseEntity.unprocessableEntity().body("Expired token.");
        }

        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
        verificationToken.getUser().setActivated(true);
        tokenVerificationRepository.save(verificationToken);

        return ResponseEntity.ok(verificationToken.getUser().getName() + ", "
        		+ "you have successfully verified your email address.");
    }
}
