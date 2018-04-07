package isa.projekat.services;

public interface EmailService {

	boolean sendEmail(String toEmail,  String verificationCode, String url);
	
}
