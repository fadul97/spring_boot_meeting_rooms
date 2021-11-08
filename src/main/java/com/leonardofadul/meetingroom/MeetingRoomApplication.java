package com.leonardofadul.meetingroom;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardofadul.meetingroom.domain.Address;
import com.leonardofadul.meetingroom.domain.City;
import com.leonardofadul.meetingroom.domain.Company;
import com.leonardofadul.meetingroom.domain.MeetingRoom;
import com.leonardofadul.meetingroom.domain.State;
import com.leonardofadul.meetingroom.repositories.AddressRepository;
import com.leonardofadul.meetingroom.repositories.CityRepository;
import com.leonardofadul.meetingroom.repositories.CompanyRepository;
import com.leonardofadul.meetingroom.repositories.MeetingRoomRepository;
import com.leonardofadul.meetingroom.repositories.StateRepository;

@SpringBootApplication
public class MeetingRoomApplication implements CommandLineRunner{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private MeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company c1 = new Company(1, "Company 1", "company1@gmail.com", "company1");
		Company c2 = new Company(2, "Company 2", "company2@gmail.com", "company2");
		Company c3 = new Company(3, "Company 3", "company3@gmail.com", "company3");
		Company c4 = new Company(4, "Company 4", "company4@gmail.com", "company4");
		
		c1.getTelephones().add("934778524");
		c2.getTelephones().addAll(Arrays.asList("988744152", "986321222"));
		c3.getTelephones().add("996541757");
		c4.getTelephones().add("998755623");
		
		State st1 = new State(null, "São Paulo");
		State st2 = new State(null, "Minas Gerais");
		State st3 = new State(null, "Rio de Janeiro");
		
		City ct1 = new City(null, "Uberlândia", st2);
		City ct2 = new City(null, "São Paulo", st1);
		City ct3 = new City(null, "Rio de Janeiro", st3);
		City ct4 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(ct2, ct4));
		st2.getCities().add(ct1);
		st3.getCities().add(ct3);
		
		stateRepository.saveAll(Arrays.asList(st1, st2, st3));
		cityRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Sala 203", "Jardim", "38220834", ct1);
        Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", ct2);
        Address a3 = new Address(null, "Avenida Peixoto", "350", "Sala 25", "Centro", "95652236", ct2);
        Address a4 = new Address(null, "Rua Chic", "2106", "Sala 28", "Centro", "987765532", ct3);
        Address a5 = new Address(null, "Avenida Varginha", "405", "Sala 7", "Centro", "78956123", ct4);
        Address a6 = new Address(null, "Morro Floriano", "3000", "Sala 1", "Centro", "75482159", ct4);
        Address a7 = new Address(null, "Avenida Floriano", "216", "Sala 15", "Centro", "15942635", ct1);
        Address a8 = new Address(null, "Bairro Mineirinho", "98", "Sala 18", "Centro", "14852012", ct1);
		
		MeetingRoom mr1 = new MeetingRoom(null, "Room 1", true, true, true, true, 10, 150.00, a1);
		MeetingRoom mr2 = new MeetingRoom(null, "Room 2", false, false, false, false, 2, 40.00, a2);
		MeetingRoom mr3 = new MeetingRoom(null, "Room 3", true, false, true, false, 3, 60.00, a3);
		MeetingRoom mr4 = new MeetingRoom(null, "Room 4", false, true, true, false, 5, 70.00, a4);
		MeetingRoom mr5 = new MeetingRoom(null, "Room 5", true, false, false, true, 6, 80.00, a5);
		MeetingRoom mr6 = new MeetingRoom(null, "Room 6", true, true, true, false, 5, 100.00, a6);
		MeetingRoom mr7 = new MeetingRoom(null, "Room 7", true, true, false, false, 7, 90.00, a7);
		MeetingRoom mr8 = new MeetingRoom(null, "Room 8", true, true, true, false, 8, 110.00, a8);
		
		c1.getRooms().addAll(Arrays.asList(mr3, mr5));
		c2.getRooms().addAll(Arrays.asList(mr1, mr6));
		c3.getRooms().add(mr2);
		c4.getRooms().addAll(Arrays.asList(mr4, mr7, mr8));
		
		mr1.setCompany(c2);
		mr2.setCompany(c3);
		mr3.setCompany(c1);
		mr4.setCompany(c4);
		mr5.setCompany(c1);
		mr6.setCompany(c2);
		mr7.setCompany(c4);
		mr8.setCompany(c4);
		
		companyRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8));
		meetingRoomRepository.saveAll(Arrays.asList(mr1, mr2, mr3, mr4, mr5, mr6, mr7, mr8));
	
	}
}
