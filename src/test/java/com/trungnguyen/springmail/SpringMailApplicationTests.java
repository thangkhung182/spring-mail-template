package com.trungnguyen.springmail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.Assert;

@SpringBootTest
class SpringMailApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	void contextLoads() {
		Assert.isTrue(mailSender != null);
	}

}
