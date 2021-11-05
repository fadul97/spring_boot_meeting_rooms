package com.leonardofadul.meetingroom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardofadul.meetingroom.domain.Company;
import com.leonardofadul.meetingroom.repositories.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repo;
	
	public Company find(Integer id) {
		Optional<Company> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
