package com.eventsource.totvs.axon.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventsource.totvs.axon.model.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
	

}
