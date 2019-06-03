package com.eventsource.totvs.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class ItemUpdatedEvent {

	private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}