package isa.projekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RezervacijaKarataApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(RezervacijaKarataApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RezervacijaKarataApplication.class, args);
	}
}
