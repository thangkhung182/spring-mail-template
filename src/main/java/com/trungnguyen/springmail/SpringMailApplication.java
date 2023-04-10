package com.trungnguyen.springmail;

import com.trungnguyen.springmail.mapper.RpKpiCbclDailyMapper;
import com.trungnguyen.springmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Map;

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
		var day = LocalDate.of(2022, 10, 4);
		var data = rpKpiCbclDailyMapper.selectByDay(day);
		emailService.sendSimpleMail("Kpi kbcl ngay " + day, "trungnq@vhc.com.vn",
				"kpiCbcl.html", Map.of("kpiCbclList", data, "day", day.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	}

}
