package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"com"})
@RestController
public class SpringBootLoggingApplication {

	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootLoggingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
		logger.debug("This is a debug message");
		logger.warn("This is a warn message");
		logger.info("This is a info message");
		logger.error("This is a error message");
	
	}

	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		logger.debug("this is debg msg from welcome msg method");
		logger.info("welcomeMsg() execution started...");
		String msg = "welcome to Ashok It";
		try {
			int i = 10 / 0;
		} catch (Exception e) {
			logger.error("Exception Occured" + e.getMessage());
		}
		logger.warn("This is warning from welcome method");
		logger.info("welcomeMsg() execution ended...");
		return msg;
	}
	
	@GetMapping("/greet")
	public String greetMsg() {
		logger.info("greetMsg() execution started...");
		String msg = "Good Morning....";
		logger.info("greetMsg() execution ended...");
		return msg;
	}
	
	
}
