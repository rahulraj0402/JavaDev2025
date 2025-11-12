package com.techverse.rahul.internalWorkingOfSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringBootApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringBootApplication.class, args);

	}

//	RazorPaymentService paymentService;
	private final paymentService paymentService ;

	public InternalWorkingOfSpringBootApplication (paymentService paymentService){
		this.paymentService = paymentService;
	}
	@Override
	public void run(String... args) throws Exception {
		// this is from command line runner , which generally runs after the spring bppt application fully starts
		String payments = paymentService.pay();
		System.out.println("payment done : " + payments );

	}
}
