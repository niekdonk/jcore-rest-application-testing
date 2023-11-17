package nl.jcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestingRestApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestingRestApplication::main).with(TestTestingRestApplication.class).run(args);
	}

}
