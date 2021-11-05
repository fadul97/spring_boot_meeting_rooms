package com.leonardofadul.meetingroom.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardofadul.meetingroom.domain.Company;
import com.leonardofadul.meetingroom.services.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource {
	
	@Autowired
	private CompanyService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> find(@PathVariable Integer id) {
		Company obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
