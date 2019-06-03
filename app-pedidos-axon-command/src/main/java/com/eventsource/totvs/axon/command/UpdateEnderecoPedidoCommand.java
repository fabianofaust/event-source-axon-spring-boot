package com.eventsource.totvs.axon.command;

import java.util.List;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.eventsource.totvs.axon.model.Endereco;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateEnderecoPedidoCommand {

	@TargetAggregateIdentifier
	private String id;
    private Endereco enderecoEntrega;
}