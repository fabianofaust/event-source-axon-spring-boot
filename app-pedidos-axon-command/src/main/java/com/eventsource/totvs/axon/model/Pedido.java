package com.eventsource.totvs.axon.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
 	private String id;
    private Integer numeroPedido;
    private User user;
    private List<Item> itens;
}
