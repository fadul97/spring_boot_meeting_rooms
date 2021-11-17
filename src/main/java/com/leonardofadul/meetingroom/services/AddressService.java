package com.leonardofadul.meetingroom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardofadul.meetingroom.domain.Address;
import com.leonardofadul.meetingroom.exceptions.ObjectNotFoundException;
import com.leonardofadul.meetingroom.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	public Address find(Integer id) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object now found! Id: " + id + ". Type: " + Address.class.getName()));
	}
}
