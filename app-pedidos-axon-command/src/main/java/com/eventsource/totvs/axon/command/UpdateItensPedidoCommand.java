package com.eventsource.totvs.axon.command;

import java.util.List;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.eventsource.totvs.axon.model.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateItensPedidoCommand {
	
	@TargetAggregateIdentifier
	private String id;
    private List<Item> itens;
}