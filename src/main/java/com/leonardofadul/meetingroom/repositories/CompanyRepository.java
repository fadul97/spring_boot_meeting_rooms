package com.leonardofadul.meetingroom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardofadul.meetingroom.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
