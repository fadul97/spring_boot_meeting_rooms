package com.leonardofadul.meetingroom.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardofadul.meetingroom.domain.Address;
import com.leonardofadul.meetingroom.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> find(@PathVariable Integer id) {
		Address obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
