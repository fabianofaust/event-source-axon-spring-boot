package com.eventsource.totvs.axon.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventsource.totvs.axon.exception.ObjectNotFoundException;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.repository.ItemRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {
	
    private ItemRepository repository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Item>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @GetMapping("/byid/{id}")
    public ResponseEntity<Item> getById(@PathVariable String id ) {
    	Optional <Item> obj= repository.findById(id);
    	Item item = obj.orElseThrow(() -> new ObjectNotFoundException());
       return ResponseEntity.ok(item);
    }
}