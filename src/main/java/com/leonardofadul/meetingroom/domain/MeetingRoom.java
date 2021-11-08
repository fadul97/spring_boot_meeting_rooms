package com.leonardofadul.meetingroom.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MeetingRoom implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Boolean airConditioner;
	private Boolean blackBoard;
	private Boolean television;
	private Boolean wifi;
	private Integer size;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToOne
	private Address address;
	
	public MeetingRoom() {
	}

	public MeetingRoom(Integer id, String name, Boolean airConditioner, Boolean blackBoard, Boolean television,
			Boolean wifi, Integer size, Double price, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.airConditioner = airConditioner;
		this.blackBoard = blackBoard;
		this.television = television;
		this.wifi = wifi;
		this.size = size;
		this.price = price;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(Boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public Boolean getBlackBoard() {
		return blackBoard;
	}

	public void setBlackBoard(Boolean blackBoard) {
		this.blackBoard = blackBoard;
	}

	public Boolean getTelevision() {
		return television;
	}

	public void setTelevision(Boolean television) {
		this.television = television;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingRoom other = (MeetingRoom) obj;
		return Objects.equals(id, other.id);
	}
}
