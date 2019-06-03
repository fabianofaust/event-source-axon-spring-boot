package com.eventsource.totvs.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class UpdateItemCommand {

    @TargetAggregateIdentifier
    private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}
