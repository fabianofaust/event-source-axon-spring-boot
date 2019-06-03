package com.eventsource.totvs.axon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/events")
public class EventController {
	
	@Autowired
    private EventStore eventStore;

    @GetMapping
    @RequestMapping("/{id}")
    @Transactional(readOnly = true)
    public List<EventMessage> listEvents(@PathVariable String id) {
        return eventStore.readEvents(id)
                .asStream()
                .collect(Collectors.toList());
    }


    
}