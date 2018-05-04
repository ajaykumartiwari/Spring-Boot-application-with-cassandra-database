package com.event.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.event.model.GameEvent;

public interface EventRepository extends CassandraRepository<GameEvent> {

}
