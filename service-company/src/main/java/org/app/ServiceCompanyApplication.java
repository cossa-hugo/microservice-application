package org.app;

import org.app.dao.CompanyRepository;
import org.app.entity.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompanyRepository companyRepository){
		return args -> {
			Stream.of("Facebook", "Twitter", "Block Secure", "Escp").forEach(companyName ->{
				companyRepository.save(new Company(null, companyName, 100+Math.random()*900));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}

}
