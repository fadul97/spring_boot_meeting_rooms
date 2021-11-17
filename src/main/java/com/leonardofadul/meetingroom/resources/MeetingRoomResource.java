package com.leonardofadul.meetingroom.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardofadul.meetingroom.domain.MeetingRoom;
import com.leonardofadul.meetingroom.services.MeetingRoomService;

@RestController
@RequestMapping(value = "/meeting_rooms")
public class MeetingRoomResource {
	
	@Autowired
	private MeetingRoomService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MeetingRoom> find(@PathVariable Integer id) {
		MeetingRoom obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
