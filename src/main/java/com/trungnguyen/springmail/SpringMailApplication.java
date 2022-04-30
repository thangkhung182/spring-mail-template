package com.trungnguyen.springmail;

import com.trungnguyen.springmail.mapper.RpKpiCbclDailyMapper;
import com.trungnguyen.springmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMailApplication implements CommandLineRunner {

	@Autowired
	private EmailService emailService;

	@Autowired
	RpKpiCbclDailyMapper rpKpiCbclDailyMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rpKpiCbclDailyMapper.selectAll().forEach(
				e -> {
					if (e.getCenter() != null) {
						System.out.println(e.getCenter());
					}
				}
		);
//		emailService.sendSimpleMail("test thymleaf", "thangkhung156@gmail.com",
//				"person.html", Map.of("persons", List.of(
//						new Person("John", "Wick"),
//						new Person("Tony", "Stark")
//				)));
	}

}
