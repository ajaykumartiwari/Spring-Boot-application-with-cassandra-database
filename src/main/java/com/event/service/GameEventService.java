package com.event.service;

import org.springframework.data.cassandra.repository.MapId;

import com.event.model.GameEvent;

public interface GameEventService {

	public GameEvent createEvents(GameEvent event);
	public Iterable<GameEvent> getAllEvents();
	GameEvent findById(MapId id);
	GameEvent delete(MapId id);
	public void deleteAll();
	public boolean checkId(MapId id);
}
