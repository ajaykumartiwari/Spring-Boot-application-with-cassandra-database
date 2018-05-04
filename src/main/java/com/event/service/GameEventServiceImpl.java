package com.event.service;

import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import com.event.model.GameEvent;
import com.event.repo.EventRepository;

@Service
public class GameEventServiceImpl implements GameEventService{

	EventRepository eventRepo;
	
	
	public GameEventServiceImpl(EventRepository eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}


	@Override
	public GameEvent createEvents(GameEvent event) {
		// TODO Auto-generated method stub
		try {
			eventRepo.save(event);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}


	@Override
	public Iterable<GameEvent> getAllEvents() {
		// TODO Auto-generated method stub
		return eventRepo.findAll();
	}


	@Override
	public GameEvent delete(MapId id) {
		// TODO Auto-generated method stub
		GameEvent event = findById(id);
		if(event != null) {
			eventRepo.delete(event);
		}
		return event;
	}
	public boolean checkId(MapId id)
	{
		return eventRepo.exists(id);
	}

	@Override
	public GameEvent findById(MapId id) {
		// TODO Auto-generated method stub
		return eventRepo.findOne(id);
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		Iterable<GameEvent> event= eventRepo.findAll();
		eventRepo.delete(event);
	}

	
}
