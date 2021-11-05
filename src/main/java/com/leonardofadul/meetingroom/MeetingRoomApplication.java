package com.leonardofadul.meetingroom;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardofadul.meetingroom.domain.Company;
import com.leonardofadul.meetingroom.repositories.CompanyRepository;

@SpringBootApplication
public class MeetingRoomApplication implements CommandLineRunner{
	
	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company c1 = new Company(1, "Company 1", "company1");
		Company c2 = new Company(2, "Company 2", "company2");
		Company c3 = new Company(3, "Company 3", "company3");
		Company c4 = new Company(4, "Company 4", "company4");
		
		companyRepository.saveAll(Arrays.asList(c1, c2, c3, c4));	
	}
}
