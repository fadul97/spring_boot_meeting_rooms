package com.leonardofadul.meetingroom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.leonardofadul.meetingroom.domain.Company;
import com.leonardofadul.meetingroom.exceptions.DataIntegrityException;
import com.leonardofadul.meetingroom.exceptions.ObjectNotFoundException;
import com.leonardofadul.meetingroom.repositories.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repo;
	
	public Company find(Integer id) {
		Optional<Company> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object now found! Id: " + id + ". Type: " + Company.class.getName()));
	}
	
	public Company insert(Company obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Company update(Company obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try{
	        repo.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	    	throw new DataIntegrityException("It is not possible to delete a company that still has rooms to rent.");
	    }
	}
}
