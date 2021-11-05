package com.leonardofadul.meetingroom.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardofadul.meetingroom.domain.Company;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource {
	
	@GetMapping
	public List<Company> find() {
		Company c1 = new Company(1, "Company 1", "company1");
		Company c2 = new Company(2, "Company 2", "company2");
		Company c3 = new Company(3, "Company 3", "company3");
		Company c4 = new Company(4, "Company 4", "company4");
	
		List<Company> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2, c3, c4));
		
		return list;
	}

}
