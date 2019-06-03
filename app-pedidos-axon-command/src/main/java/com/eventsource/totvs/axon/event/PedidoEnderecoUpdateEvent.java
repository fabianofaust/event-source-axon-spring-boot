package com.eventsource.totvs.axon.event;

import java.util.List;

import com.eventsource.totvs.axon.model.Endereco;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PedidoEnderecoUpdateEvent {

	private String id;
    private Endereco enderecoEntrega;
}