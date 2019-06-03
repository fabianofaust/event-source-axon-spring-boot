package com.eventsource.totvs.axon.event;

import java.util.List;

import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PedidoUpdatedEvent {

	private String id;
    private Integer numeroPedido;
    private User user;
    private List<Item> itens;
}