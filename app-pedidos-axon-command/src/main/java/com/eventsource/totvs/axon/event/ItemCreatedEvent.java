package com.eventsource.totvs.axon.event;

import java.math.BigDecimal;

import com.eventsource.totvs.axon.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ItemCreatedEvent {

	private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}