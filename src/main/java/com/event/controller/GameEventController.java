package com.event.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.model.GameEvent;
import com.event.repo.EventRepository;
import com.event.service.GameEventService;
import com.event.service.GameEventServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Api(value= "Game_EventApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameEventController {

	@Autowired
	GameEventService eventService;
	
	@ApiOperation("Get all Events")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = GameEvent.class )})
	@GetMapping("/events")
	public List<GameEvent> getAllEvents() {
		System.out.println("Get all Events...");

		List<GameEvent> events = new ArrayList<>();
		eventService.getAllEvents().forEach(events::add);
		System.out.println(events);
		return events;
	}
	
	@ApiOperation("Post Events")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = GameEvent.class )})
	@PostMapping("/events/create")
	public ResponseEntity<GameEvent> createEvents(@RequestBody GameEvent event) {
		GameEvent _event = eventService.createEvents(event); 
		return new ResponseEntity<>(_event, HttpStatus.OK);
	}
	
	

//	@PutMapping("/events/{id}")
//	public ResponseEntity<GameEvent> updateEvents(@PathVariable("id") UUID id, @RequestBody GameEvent event) {
//		System.out.println("Update Event with ID = " + id + "...");
//
//		GameEvent eventData = eventRepository.findOne(BasicMapId.id("id", id));
//		if (eventData == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		eventData.setName(event.getName());
//		eventData.setAge(event.getAge());
//		eventData.setActive(event.isActive());
//		GameEvent updatedEvent = eventRepository.save(eventData);
//		return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
//	}
//	
	@ApiOperation("Delete Event by User ID")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = GameEvent.class )})
	@DeleteMapping("/events/delete/{userId}")
	public ResponseEntity<String> deleteEventByUserId(@PathVariable("userId") int userId) throws Exception {
		System.out.println("Delete Event with ID = " + userId + "...");

		if(eventService.checkId(BasicMapId.id("userId", userId)))
				{		
			eventService.delete(BasicMapId.id("userId", userId));

		return new ResponseEntity<>("Event has been deleted!", HttpStatus.OK);
		}
		else
		{
			throw new Exception("event with id "+userId+" does not exist");
		}
	}
	
	@ApiOperation("Delete all Events")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = GameEvent.class )})
	@DeleteMapping("/events/delete")
	public ResponseEntity<String> deleteAllEvents() {
		System.out.println("All Events Deleted...");

		eventService.deleteAll();

		return new ResponseEntity<>("All events have been deleted!", HttpStatus.OK);
	}
}