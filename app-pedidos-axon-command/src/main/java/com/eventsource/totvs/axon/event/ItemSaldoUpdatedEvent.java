package com.eventsource.totvs.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ItemSaldoUpdatedEvent {

	private String id;
	private Integer saldo;
}