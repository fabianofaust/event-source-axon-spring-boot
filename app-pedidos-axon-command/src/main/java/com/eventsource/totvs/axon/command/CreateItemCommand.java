package com.eventsource.totvs.axon.command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateItemCommand {

	@TargetAggregateIdentifier
	private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}