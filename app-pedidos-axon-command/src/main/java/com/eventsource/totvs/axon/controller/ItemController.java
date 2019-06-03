package com.eventsource.totvs.axon.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventsource.totvs.axon.command.CreateItemCommand;
import com.eventsource.totvs.axon.command.RemoveItemCommand;
import com.eventsource.totvs.axon.command.UpdateItemCommand;
import com.eventsource.totvs.axon.command.UpdateSaldoItemCommand;
import com.eventsource.totvs.axon.dto.ItemDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private CommandGateway commandGateway;
    
    @PostMapping
    public CompletableFuture<String> create(@RequestBody ItemDTO dto) {
        var command = new CreateItemCommand(UUID.randomUUID().toString(), dto.getNome(), dto.getSaldo(), dto.getValor());
        return commandGateway.send(command);
    }

    @PutMapping("/{id}/saldo")
    public CompletableFuture<String> updateSaldo(@PathVariable String id, @RequestBody ItemDTO dto) {
        var command = new UpdateSaldoItemCommand(id, dto.getSaldo());
        return commandGateway.send(command);
    }
    
    @PutMapping("/{id}")
    public CompletableFuture<String> update(@PathVariable String id, @RequestBody ItemDTO dto) {
        var command = new UpdateItemCommand(id, dto.getNome(), dto.getSaldo(),dto.getValor());
        return commandGateway.send(command);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> remove(@PathVariable String id) {
        var command = new RemoveItemCommand(id);
        return commandGateway.send(command);
    }
}