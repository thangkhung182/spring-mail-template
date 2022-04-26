package com.trungnguyen.springmail;

import com.trungnguyen.springmail.model.Person;
import com.trungnguyen.springmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringMailApplication implements CommandLineRunner {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		emailService.sendSimpleMail("test thymleaf", "thangkhung156@gmail.com",
				"person.html", Map.of("persons", List.of(
						new Person("John", "Wick"),
						new Person("Tony", "Stark")
				)));
	}

}
