package com.leonardofadul.meetingroom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardofadul.meetingroom.domain.MeetingRoom;
import com.leonardofadul.meetingroom.exceptions.ObjectNotFoundException;
import com.leonardofadul.meetingroom.repositories.MeetingRoomRepository;

@Service
public class MeetingRoomService {
	
	@Autowired
	private MeetingRoomRepository repo;
	
	public MeetingRoom find(Integer id) {
		Optional<MeetingRoom> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object now found! Id: " + id + ". Type: " + MeetingRoom.class.getName()));
	}
}
