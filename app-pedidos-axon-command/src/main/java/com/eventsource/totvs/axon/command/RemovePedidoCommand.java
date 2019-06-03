package com.eventsource.totvs.axon.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class RemovePedidoCommand {

    @TargetAggregateIdentifier
    private String id;
}
