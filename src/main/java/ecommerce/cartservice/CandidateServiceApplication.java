package ecommerce.cartservice;

import ecommerce.cartservice.service.CandidateServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication

public class CandidateServiceApplication {

	//force push
	public static void main(String[] args) {

		SpringApplication.run(CandidateServiceApplication.class, args);
	}
}
