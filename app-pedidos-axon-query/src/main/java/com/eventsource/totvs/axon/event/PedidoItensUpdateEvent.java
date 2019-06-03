package com.eventsource.totvs.axon.event;

import java.util.List;

import com.eventsource.totvs.axon.model.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PedidoItensUpdateEvent {

	private String id;
    private List<Item> itens;
}