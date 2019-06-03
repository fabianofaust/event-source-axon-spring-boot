package com.eventsource.totvs.axon.controller;

import java.util.Random;
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

import com.eventsource.totvs.axon.command.CreatePedidoCommand;
import com.eventsource.totvs.axon.command.RemovePedidoCommand;
import com.eventsource.totvs.axon.command.UpdateEnderecoPedidoCommand;
import com.eventsource.totvs.axon.command.UpdateItensPedidoCommand;
import com.eventsource.totvs.axon.command.UpdatePedidoCommand;
import com.eventsource.totvs.axon.dto.PedidoDTO;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private CommandGateway commandGateway;
    
    @PostMapping
    public CompletableFuture<String> create(@RequestBody PedidoDTO dto) {
        var command = new CreatePedidoCommand(UUID.randomUUID().toString(), generateNumber(), dto.getUser(), dto.getItens(), dto.getEnderecoEntrega());
        return commandGateway.send(command);
    }
    
    @PutMapping("/{id}/endereco")
    public CompletableFuture<String> update(@PathVariable String id, @RequestBody PedidoDTO dto) {
        var command = new UpdateEnderecoPedidoCommand(id,dto.getEnderecoEntrega());
        return commandGateway.send(command);
    }
    
    @PutMapping("/{id}/itens")
    public CompletableFuture<String> updateItens(@PathVariable String id, @RequestBody PedidoDTO dto) {
        var command = new UpdateItensPedidoCommand(id, dto.getItens());
        return commandGateway.send(command);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> remove(@PathVariable String id) {
        var command = new RemovePedidoCommand(id);
        return commandGateway.send(command);
    }
    
	private Integer generateNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}