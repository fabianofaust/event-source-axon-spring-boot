package com.eventsource.totvs.axon.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventsource.totvs.axon.exception.ObjectNotFoundException;
import com.eventsource.totvs.axon.model.Pedido;
import com.eventsource.totvs.axon.repository.PedidoRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
	
    private PedidoRepository repository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Pedido>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @GetMapping("/byid/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable String id ) {
    	Optional <Pedido> obj= repository.findById(id);
    	Pedido pedido = obj.orElseThrow(() -> new ObjectNotFoundException());
       return ResponseEntity.ok(pedido);
    }
}